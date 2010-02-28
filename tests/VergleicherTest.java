import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;
import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: mouk
 * Date: 28.02.2010
 * Time: 22:03:45
 * To change this template use File | Settings | File Templates.
 */
public class VergleicherTest {
    private final String first = "first.txt";
    private final String second = "second.txt";
    private final String third = "third.txt";
    private final String fourth = "fourth.txt";
    @Before
    public void setUp() throws Exception {
        createFile(first, "Mouk Mouk\nm");
        createFile(second, "Mouk Mouk\nm");
        createFile(third, "Mouk Mou_\nm");
        createFile(fourth, "Mouk Mouk");

    }

    private void createFile(String file,String output) throws IOException {
        File f=new File(file);
        if(f.exists())
            f.delete();
        f.createNewFile();
        FileOutputStream stream = new FileOutputStream(f);
        stream.write(output.getBytes());
        stream.close();
    }

    @After
    public void tearDown() throws Exception {
        deleteFile(first);
        deleteFile(second);
        deleteFile(third);
        deleteFile(fourth);
    }

    private void deleteFile(String file) {
        File f=new File(file);
        if(f.exists())
            f.delete();
    }

    @Test
    public void equals_TwoIdenticalFiles_True() throws Exception {
        Vergleicher v = new Vergleicher();
        Boolean result = v.istEqual(new File(first),new File(second));
        Assert.assertTrue(result) ;       
    }

    @Test
    public void equals_TwoDifferentFiles_False() throws Exception {
        Vergleicher v = new Vergleicher();
        Boolean result = v.istEqual(new File(first),new File(third));
        Assert.assertFalse(result);
    }

    @Test
    public void equals_TwoFilesWithDifferentNumOfLines_False() throws Exception {
        Vergleicher v = new Vergleicher();
        Boolean result = v.istEqual(new File(first),new File(fourth));
        Assert.assertFalse(result);

        result = v.istEqual(new File(fourth), new File(first));
        Assert.assertFalse(result);
        }
}
