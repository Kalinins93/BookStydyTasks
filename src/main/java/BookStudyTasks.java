import javax.swing.JOptionPane;
public class BookStudyTasks {
    public static void main(String arg []){
        int a;
        int b;

        String inputA = JOptionPane.showInputDialog("Input A");
        a=Integer.parseInt(inputA);
        String inputB = JOptionPane.showInputDialog("Input B");
        b=Integer.parseInt(inputB);
        a=a+b;
        double y=(double)a;
        JOptionPane.showMessageDialog(null,"Result a+b="
                +String.valueOf(y));


    }

}
