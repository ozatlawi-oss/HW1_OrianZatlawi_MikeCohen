public class File {
    private String fileName;
    private String fileType;

    /**
     * Constructs a new File object.
     *
     * @param fileName The name of the file (e.g., "report", "image01").
     * @param fileType The type or extension of the file (e.g., "txt", "png").
     * @throws IllegalArgumentException if the fileName or fileType is empty.
     */
    public File(String fileName, String fileType) {
        if(fileName.isEmpty() || fileType.isEmpty()){
            throw new IllegalArgumentException("File name/type cannot be empty");
        }
        this.fileName = fileName;
        this.fileType = fileType;
    }
    @Override
    public String toString()
    {
        return "{fileName: " + fileName + ", fileType: " + fileType + "}";
    }

    // הוספתי גטים וסטים משמש
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        if(fileName == null|| fileName.isEmpty())
            throw new IllegalArgumentException("File name cannot be empty");
        this.fileName = fileName;

    }

    /**
     *
     * @return file type
     */
    public String getFileType() {
    return fileType;
    }

    /**
     * Method to update file type if it is empty or does not exist throws an exception
     * @param fileType
     */
    public void setFileType(String fileType) {
        if(fileType == null || fileType.isEmpty())
            throw new IllegalArgumentException("File type cannot be empty");
        this.fileType = fileType;
    }
}
