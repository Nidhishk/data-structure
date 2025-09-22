import java.io.*;
import java.util.Arrays;

public class Main_x {
    public static void main(String[] args) {

        //String filePath = "/Users/nidhish/Downloads/Firefox Setup 14.0.1.msi"; // Replace with your actual file path
        //String filePath = "/Users/nidhish/Downloads/SampleDOCFile_100kb.doc";
        String filePath = "/Users/nidhish/Downloads/sample2.ppt";
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

    // CFBF (Compound File Binary Format) signature
    private static final byte[] CFBF_SIGNATURE = {
            (byte) 0xD0, (byte) 0xCF, (byte) 0x11, (byte) 0xE0,
            (byte) 0xA1, (byte) 0xB1, (byte) 0x1A, (byte) 0xE1
    };

    // SummaryInformation stream name in UTF-16LE
    private static final byte[] SUMMARY_INFO = {
            0x05, 0x00, 0x53, 0x00, 0x75, 0x00, 0x6D, 0x00,
            0x6D, 0x00, 0x61, 0x00, 0x72, 0x00, 0x79, 0x00,
            0x49, 0x00, 0x6E, 0x00, 0x66, 0x00, 0x6F, 0x00
    };

    public static boolean isMSIFile(InputStream input) throws IOException {
        // Read first 8192 bytes
        byte[] buffer = new byte[8192];
        int bytesRead = input.read(buffer);

        // Debug prints
        System.out.println("Bytes read: " + bytesRead);
        System.out.println("First 8 bytes: " + Arrays.toString(Arrays.copyOfRange(buffer, 0, 8)));

        if (bytesRead < 512) {
            return false;
        }

        // Check CFBF signature
        if (!Arrays.equals(Arrays.copyOfRange(buffer, 0, 8), CFBF_SIGNATURE)) {
            return false;
        }

        // Look for SummaryInformation stream
        for (int i = 0; i < bytesRead - SUMMARY_INFO.length; i++) {
            boolean found = true;
            for (int j = 0; j < SUMMARY_INFO.length; j++) {
                if (buffer[i + j] != SUMMARY_INFO[j]) {
                    found = false;
                    break;
                }
            }
            if (found) {
                // Found SummaryInformation stream, now look for MSI specific patterns
                String content = new String(buffer, "UTF-16LE");
                return content.contains("Windows Installer") ||
                        content.contains("MSI") ||
                        content.contains("Installation Database");
            }
        }

        return false;
    }
}