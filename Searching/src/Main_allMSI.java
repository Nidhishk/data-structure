import java.io.*;

public class Main_allMSI {
    public static void main(String[] args) {

        String filePath = "/Users/nidhish/Downloads/Firefox Setup 14.0.1.msi"; // Replace with your actual file path
        //String filePath = "/Users/nidhish/Downloads/SampleDOCFile_100kb.doc";
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

            if (isMsiFile(inputStream)) {
                System.out.println("It's an MSI file!");
            } else {
                System.out.println("It's not an MSI file.");
            }

            // Close the input stream when you're done
            inputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    private static final byte[] MSI_MAGIC_NUMBER = {(byte) 0xD0, (byte) 0xCF, (byte) 0x11, (byte) 0xE0};

    public static boolean isMsiFile(InputStream inputStream) throws IOException {
        byte[] fileHeader = new byte[MSI_MAGIC_NUMBER.length];
        int bytesRead = inputStream.read(fileHeader, 0, MSI_MAGIC_NUMBER.length);

        if (bytesRead < MSI_MAGIC_NUMBER.length) {
            return false;
        }

        for (int i = 0; i < MSI_MAGIC_NUMBER.length; i++) {
            if (fileHeader[i] != MSI_MAGIC_NUMBER[i]) {
                return false;
            }
        }
        return true;
    }
}