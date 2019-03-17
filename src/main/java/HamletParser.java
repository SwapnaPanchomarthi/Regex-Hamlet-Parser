import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by thook on 10/7/15.
 */
public class HamletParser {

    private String hamletData;

    public HamletParser(){
        this.hamletData = loadFile();
    }

    private String loadFile(){
        //Create a new JavaClassLoader
        ClassLoader classLoader = getClass().getClassLoader();
        //Create file
        File file = new File(classLoader.getResource("hamlet.txt").getFile());
        System.out.println(file);


        StringBuilder result = new StringBuilder("");

        try(Scanner scanner = new Scanner(file)){
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                result.append(line).append("\n");
            }

            scanner.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        return result.toString();
    }
    protected String  method2(String inputLine, String searchStr, String repStr)

    {

        String patternString = searchStr;
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputLine);
        hamletData =matcher.replaceAll(repStr);
        System.out.println(hamletData);
        return String.valueOf(matcher);
    }

    public String getHamletData(){

        return hamletData;
    }

    public boolean match(String str) {
        boolean flag=false;
        String patternString = str;
        Pattern pattern = Pattern.compile(patternString, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(hamletData);
        if(matcher.find())
        flag=true;

        else
            flag=false;

        return flag;

    }


}

