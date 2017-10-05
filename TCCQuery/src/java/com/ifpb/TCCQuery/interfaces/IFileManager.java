package com.ifpb.TCCQuery.interfaces;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public interface IFileManager {
    
    default public String uploadFile(String nameFolder, HttpServletRequest req, 
            Part part, String IDPhoto) throws IOException {
       
       //Separador de arquivo: \
       String sep = File.separator;
       //Nome do arquivo junto à extensão
       String nameFile = part.getSubmittedFileName();
       //Extensão do arquivo
       String extFile = nameFile.substring(nameFile.lastIndexOf("."));
       //Caminho da pasta web da build
       String pathFolder = sep + req.getServletContext().getRealPath(nameFolder);
       
       //Instancia arquivo
       File folder = new File(pathFolder);
       //Cria se não existir o arquivo
       if (!folder.exists()) folder.mkdirs();
       
       //Escreve o arquivo no caminho do pathFolder
       part.write(pathFolder + sep + nameFile);
       
       return nameFolder + sep + renameFile(pathFolder, nameFile, IDPhoto + extFile);
    }
    
    default public String renameFile(String pathOldFile, String oldFile, 
            String newFile) throws IOException{
        
        //Separador de arquivo: \
        String sep = File.separator;
        
        //Instancia o arquivo
        File old = new File(pathOldFile + sep + oldFile);
        //Cria o arquivo instanciado
        old.createNewFile();
        
        //Renomeia o arquivo
        if(old.renameTo(new File(pathOldFile + sep + newFile))) 
            return newFile;
        return null;
        
    }
    
    default public boolean removeFile(String pathName){
        return (new File(pathName)).delete();
    }
    
    default public boolean deleteFolderWithFile(String pathName){
        File folder = new File(pathName);
        if (folder.isDirectory()) {
            File[] sun = folder.listFiles();
            for (File toDelete : sun) {
                toDelete.delete();
            }
        }
        return folder.delete();
    }
    
    //Recebe: nome da pasta para salvamento, a requisicao e o part
    default public String uploadFile(String nameFolder, HttpServletRequest req, 
            Part part) throws IOException {
       
       //Separador de arquivo: \
       String sep = File.separator;
       //Nome do arquivo junto à extensão
       String nameFile = part.getSubmittedFileName();
       //Extensão do arquivo
       String extFile = nameFile.substring(nameFile.lastIndexOf("."));
       //Caminho da pasta web da build
       String pathFolder = req.getServletContext().getRealPath(nameFolder);
       
       //Instancia arquivo
       File folder = new File(pathFolder);
       //Cria se não existir o arquivo
       if (!folder.exists()) folder.mkdirs();
       
       //Escreve o arquivo no caminho do pathFolder
       part.write(pathFolder + sep + nameFile);
       
       return pathFolder + sep + nameFile;
    }
    
}
