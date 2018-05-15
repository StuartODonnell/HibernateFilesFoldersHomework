import com.codeclan.folders.db.DBFolder;
import com.codeclan.folders.db.DBHelper;
import com.codeclan.folders.models.File;
import com.codeclan.folders.models.Folder;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Folder folder1 = new Folder("Lever Arch");
        DBHelper.save(folder1);
        Folder folder2 = new Folder("Report");
        DBHelper.save(folder2);

        File file1 = new File("Vimes", ".rb", 35, folder1);
        DBHelper.save(file1);

        File file2 = new File("Carrot", ".txt", 50, folder1);
        DBHelper.save(file1);

        File file3 = new File("Nobby", ".py", 500, folder2);
        DBHelper.save(file3);

        List<File> files = DBHelper.getAll(File.class);
        List<Folder> folders = DBHelper.getAll(Folder.class);

        File foundFile = DBHelper.find(File.class, file2.getId());
        Folder foundFolder = DBHelper.findFolder.class, folder1.getId());

        List<File> leverArchFiles = DBFolder.getFIlesForFolder(foundFolder);

    }
}

