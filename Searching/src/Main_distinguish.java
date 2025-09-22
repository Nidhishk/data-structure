import java.io.*;

public class Main_distinguish {
    public static void main(String[] args) {

        //String filePath = "/Users/nidhish/Downloads/Firefox Setup 14.0.1.msi"; // Replace with your actual file path
        String filePath = "/Users/nidhish/Downloads/MSI-Downloader/MSI Downloader.msi";
        //String filePath = "/Users/nidhish/Downloads/SampleDOCFile_100kb.doc";
        //String filePath = "/Users/nidhish/Downloads/sample2.ppt";
        //String filePath = "/Users/nidhish/Downloads/IMG_3313 2.jpg";

        try {
            File file = new File(filePath);
            InputStream inputStream = new FileInputStream(file);

            // Now you can use the inputStream to read the file's content
            // For example, reading the file byte by byte:
//            int data;
//            while ((data = inputStream.read()) != -1) {
//                System.out.print((char) data);
//            }

            //String result = detectFileType(inputStream);
            System.out.println(isMSIFile(inputStream));

            // Close the input stream when you're done
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static final byte[] CFBF_SIGNATURE = {
            (byte) 0xD0, (byte) 0xCF, (byte) 0x11, (byte) 0xE0,
            (byte) 0xA1, (byte) 0xB1, (byte) 0x1A, (byte) 0xE1
    };

    // Read first 4KB which should contain the header and first few directory entries
    private static final int BUFFER_SIZE = 4096;

    public static boolean isMSIFile(InputStream input) throws IOException {
        // Read initial bytes into buffer
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = 0;
        int totalBytesRead = 0;

        while (totalBytesRead < BUFFER_SIZE &&
                (bytesRead = input.read(buffer, totalBytesRead, BUFFER_SIZE - totalBytesRead)) != -1) {
            totalBytesRead += bytesRead;
        }

        if (totalBytesRead < 512) { // Minimum size for a valid compound file
            return false;
        }

        // Check signature
        for (int i = 0; i < CFBF_SIGNATURE.length; i++) {
            if (buffer[i] != CFBF_SIGNATURE[i]) {
                return false;
            }
        }

        // Read sector shift (offset 0x1E = 30)
        int sectorShift = ((buffer[31] & 0xFF) << 8) | (buffer[30] & 0xFF);
        int sectorSize = 1 << sectorShift;

        // Read directory start sector (offset 0x30 = 48)
        int dirStartSector = ((buffer[51] & 0xFF) << 24) |
                ((buffer[50] & 0xFF) << 16) |
                ((buffer[49] & 0xFF) << 8) |
                (buffer[48] & 0xFF);

        if (dirStartSector < 0) {
            return false;
        }

        // Calculate directory offset
        int dirOffset = (dirStartSector + 1) * sectorSize;

        // Check if we have enough bytes in buffer to read directory
        if (dirOffset + 128 > totalBytesRead) {
            // If directory is beyond our buffer, look for other MSI indicators
            // Check sector size (MSI files typically use 512-byte sectors)
            return sectorShift == 9;
        }

        // Read first directory entry name
        boolean foundMsiSignatures = false;
        boolean foundWordSignatures = false;

        // Read up to 2 directory entries if they fit in our buffer
        for (int entryStart = dirOffset; entryStart + 128 <= totalBytesRead && entryStart < dirOffset + 256; entryStart += 128) {
            // Read entry name (first 64 bytes of directory entry)
            StringBuilder name = new StringBuilder();
            for (int i = 0; i < 64; i += 2) {
                char c = (char)(((buffer[entryStart + i + 1] & 0xFF) << 8) |
                        (buffer[entryStart + i] & 0xFF));
                if (c == 0) break;
                name.append(c);
            }

            String entryName = name.toString().trim();

            // Check for MSI-specific streams
            if (entryName.equals("_StringPool") ||
                    entryName.equals("_Tables") ||
                    entryName.equals("_Streams") ||
                    entryName.equals("@")) {
                foundMsiSignatures = true;
            }

            // Check for Word-specific streams
            if (entryName.equals("WordDocument") ||
                    entryName.equals("1Table") ||
                    entryName.equals("0Table")) {
                foundWordSignatures = true;
            }
        }
        System.out.println(foundMsiSignatures);
        System.out.println(foundWordSignatures);

        // If we found clear MSI signatures, return true
        if (foundMsiSignatures && !foundWordSignatures) {
            return true;
        }

        // Fallback to checking sector size and other structural elements
        return sectorShift == 9 && dirStartSector >= 0 && dirStartSector < 5;
    }
}