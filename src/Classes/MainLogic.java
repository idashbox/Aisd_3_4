package Classes;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.regex.Pattern;

public class MainLogic {
    public static void getAnswer(LinkedBlockingQueue<String> queue){
        int n = queue.size();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(queue.remove());
        }
        for (int i = n - 1; i >= 0; i--) {
            queue.add(list.get(i));
            queue.add(list.get(i));
        }
    }
    //    .\input.txt .\output.txt
    public static String massivVStroki(SimpleLinkedQueue<String> list){
        StringBuilder answer = new StringBuilder();
        for (String mas : list){
                answer.append(mas);
                answer.append(" ");
            }
        return answer.toString();
    }
    public static String massivVStroki(LinkedBlockingQueue<String> list){
        StringBuilder answer = new StringBuilder();
        for (String mas : list){
            answer.append(mas);
            answer.append(" ");
        }
        return answer.toString();
    }
//    public static void readAndWriteMethod(InputArgs inputArgs) throws Exception {
//        SimpleLinkedQueue<String> arr = ClassesForInAndOut.readFile(inputArgs.getInputFile());
//        arr.getAnswer();
//        String answer = MainLogic.massivVStroki(arr);
//        ClassesForInAndOut.writeFile(inputArgs.getOutputFile(),answer);
//    }
//    public static void printSuccessMessage(int num){
//        if(num==0){
//            System.out.println("Основная программа выполнена.");
//        }else{
//            System.out.println("Тест " + num + " выполнен успешно.");
//        }
//        System.out.println();
//    }
}
