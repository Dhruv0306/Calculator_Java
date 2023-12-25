import javax.swing.*;
import java.awt.*;


/**
 * @author Dhruv Patel
 * @version 1.0.0
 */

class window extends JFrame {
    public static Color font = new Color(0,255,140);
    public static Color fieldBack = new Color(54,69,79);
    public static JTextField equationBox;
    public static JLabel temp;
    private static double ans, num;
    private static int operator;
    public window(){
        //Buttons and text field
        JPanel jPanel;
        JButton zero, one, two, three, four, five, six, seven, eight, nine, plus, minus, star, divide, pow, equal, dot, clear, back;

        //JFrame properties
        this.setTitle("Calculator");
        this.setSize(350,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //JPanel properties
        jPanel = new JPanel();
        jPanel.setBackground(Color.BLACK);//Background colour
        jPanel.setLayout(null);//For custom placement of each element

        //Adding text field or equation box
        equationBox = new JTextField();
        equationBox.setLocation(30,30);//Text Field location
        equationBox.setSize(this.getWidth() - 75,35);//Text Field size
        equationBox.setFont(new Font("Roboto",Font.BOLD,20));//Font Style
        equationBox.setForeground(font);//Font Colour
        equationBox.setBackground(fieldBack);
        equationBox.setHorizontalAlignment(JTextField.RIGHT);//Text's horizontal alignment to right
        jPanel.add(equationBox);

        //JLabel properties
        temp = new JLabel();
        temp.setLocation(30,10);
        temp.setSize(this.getWidth() - 75,20);
        temp.setFont(new Font("Roboto",Font.BOLD,14));
        temp.setText("");
        temp.setHorizontalAlignment(JLabel.RIGHT);
        temp.setForeground(font);
        jPanel.add(temp);

        //Adding buttons
        zero = new JButton("0");
        addButton(jPanel, zero,35,this.getHeight()- 95,60);
        dot = new JButton(".");
        addButton(jPanel, dot,105,this.getHeight()- 95,60);
        equal = new JButton("=");
        addButton(jPanel, equal,175,this.getHeight()- 95,130);

        one = new JButton("1");
        addButton(jPanel, one,35,this.getHeight()- 140,60);
        two = new JButton("2");
        addButton(jPanel, two,105,this.getHeight()- 140,60);
        three = new JButton("3");
        addButton(jPanel, three,175,this.getHeight()- 140,60);
        plus = new JButton("+");
        addButton(jPanel, plus,245,this.getHeight() - 140,60);

        four = new JButton("4");
        addButton(jPanel, four,35,this.getHeight()- 185,60);
        five = new JButton("5");
        addButton(jPanel, five,105,this.getHeight()- 185,60);
        six = new JButton("6");
        addButton(jPanel, six,175,this.getHeight()- 185,60);
        minus = new JButton("-");
        addButton(jPanel, minus,245,this.getHeight() - 185,60);

        seven = new JButton("7");
        addButton(jPanel, seven,35,this.getHeight()- 230,60);
        eight = new JButton("8");
        addButton(jPanel, eight,105,this.getHeight()- 230,60);
        nine = new JButton("9");
        addButton(jPanel, nine,175,this.getHeight()- 230,60);
        star = new JButton("*");
        addButton(jPanel, star,245,this.getHeight()- 230,60);


        back = new JButton("⌫");
        addButton(jPanel, back,35,this.getHeight()- 275,60);
        clear = new JButton("C");
        addButton(jPanel, clear,105,this.getHeight()- 275,60);
        pow = new JButton("^");
        addButton(jPanel, pow,175,this.getHeight()-275,60);
        divide = new JButton("/");
        addButton(jPanel, divide,245,this.getHeight()- 275,60);

        zero.addActionListener(e -> equationBox.setText(equationBox.getText() + "0"));
        one.addActionListener(e -> equationBox.setText(equationBox.getText() + "1"));
        two.addActionListener(e -> equationBox.setText(equationBox.getText() + "2"));
        three.addActionListener(e -> equationBox.setText(equationBox.getText() + "3"));
        four.addActionListener(e -> equationBox.setText(equationBox.getText() + "4"));
        five.addActionListener(e -> equationBox.setText(equationBox.getText() + "5"));
        six.addActionListener(e -> equationBox.setText(equationBox.getText() + "6"));
        seven.addActionListener(e -> equationBox.setText(equationBox.getText() + "7"));
        eight.addActionListener(e -> equationBox.setText(equationBox.getText() + "8"));
        nine.addActionListener(e -> equationBox.setText(equationBox.getText() + "9"));

        // !temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1)) -> Checks consecutive oppression E.g. 6 + 6 - 3 will first result in 6 + 6 and then 12 - 3
        plus.addActionListener(e -> {
            if(!temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1))){
                if (!equationBox.getText().isEmpty()){
                    arithmetic_operation();
                    operator = 2;
                    temp.setText(temp.getText() + "+");
                    num = Double.parseDouble(equationBox.getText());
                    equationBox.setText("");
                }else{
                    temp.setText(temp.getText().substring(0,temp.getText().length() - 1) + "+");
                    operator = 2;
                }
            } else if (!equationBox.getText().isEmpty()) {
                num = Double.parseDouble(equationBox.getText());
                operator = 2;
                temp.setText(num + "+");
                equationBox.setText("");
            }
        });
        minus.addActionListener(e -> {
            if(!temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1))){
                if (!equationBox.getText().isEmpty()){
                    arithmetic_operation();
                    operator = 3;
                    temp.setText(temp.getText() + "-");
                    num = Double.parseDouble(equationBox.getText());
                    equationBox.setText("");
                }else{
                    temp.setText(temp.getText().substring(0,temp.getText().length() - 1) + "-");
                    operator = 3;
                }
            } else if (!equationBox.getText().isEmpty()) {
                num = Double.parseDouble(equationBox.getText());
                operator = 3;
                temp.setText(num + "-");
                equationBox.setText("");
            }
        });
        star.addActionListener(e -> {
            if(!temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1))){
                if (!equationBox.getText().isEmpty()){
                    arithmetic_operation();
                    operator = 4;
                    temp.setText(temp.getText() + "*");
                    num = Double.parseDouble(equationBox.getText());
                    equationBox.setText("");
                }else {
                    temp.setText(temp.getText().substring(0,temp.getText().length() - 1) + "*");
                    operator = 4;
                }
            } else if (!equationBox.getText().isEmpty()) {
                num = Double.parseDouble(equationBox.getText());
                operator = 4;
                temp.setText(num + "*");
                equationBox.setText("");
            }
        });
        divide.addActionListener(e -> {
            if(!temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1))){
                if (!equationBox.getText().isEmpty()){
                    arithmetic_operation();
                    operator = 5;
                    temp.setText(temp.getText() + "/");
                    num = Double.parseDouble(equationBox.getText());
                    equationBox.setText("");
                }else{
                    temp.setText(temp.getText().substring(0,temp.getText().length() - 1) + "/");
                    operator = 5;
                }
            } else if (!equationBox.getText().isEmpty()) {
                num = Double.parseDouble(equationBox.getText());
                operator = 5;
                temp.setText(num + "/");
                equationBox.setText("");
            }
        });
        pow.addActionListener(e -> {
            if(!temp.getText().isEmpty() && isOperator(temp.getText().charAt(temp.getText().length() - 1))){
                if (!equationBox.getText().isEmpty()){
                    arithmetic_operation();
                    operator = 1;
                    temp.setText(temp.getText() + "^");
                    num = Double.parseDouble(equationBox.getText());
                    equationBox.setText("");
                }else{
                    temp.setText(temp.getText().substring(0,temp.getText().length() - 1) + "^");
                    operator = 1;
                }
            } else if (!equationBox.getText().isEmpty()) {
                num = Double.parseDouble(equationBox.getText());
                operator = 1;
                temp.setText(num + "^");
                equationBox.setText("");
            }
        });

        dot.addActionListener(e -> equationBox.setText(equationBox.getText() + "."));
        clear.addActionListener(e -> {
            temp.setText("");
            equationBox.setText("");
        }); //Erases current equation
        back.addActionListener(e -> {
            if(equationBox.getText().isEmpty() && !temp.getText().isEmpty()){
                equationBox.setText(temp.getText().substring(0,temp.getText().length()-1));
                temp.setText(equationBox.getText());
            }else if(!equationBox.getText().isEmpty()){
                equationBox.setText(equationBox.getText().substring(0,equationBox.getText().length()-1));
            }
        }); //Removes last entered character
        equal.addActionListener(e -> arithmetic_operation()); //Solves current equation

        this.add(jPanel); // Add JPanel to JFrame
        this.setVisible(true); // Set JFrame to visible
    }
    private static void addButton(JPanel jPanel, JButton button,int x, int y, int width){
        /*Adds given button to JPanel*/
        button.setFont(new Font("Roboto",Font.BOLD,20));
        button.setForeground(font);
        button.setBackground(fieldBack);
        button.setLocation(x,y);
        button.setSize(width, 35);
        jPanel.add(button);
    }
    private static void arithmetic_operation(){
        /* Performs arithmetic operation*/
        if (!equationBox.getText().isEmpty()){
            switch (operator){
                case 1:
                    ans = Math.round(Math.pow(num, Double.parseDouble(equationBox.getText())) * 10000.0) / 10000.0;
                    equationBox.setText(String.valueOf(ans));
                    temp.setText(String.valueOf(ans));
                    break;
                case 2:
                    ans = Math.round((num + Double.parseDouble(equationBox.getText())) * 10000.0) / 10000.0;
                    equationBox.setText(String.valueOf(ans));
                    temp.setText(String.valueOf(ans));
                    break;
                case 3:
                    ans = Math.round((num - Double.parseDouble(equationBox.getText())) * 10000.0) / 10000.0;
                    equationBox.setText(String.valueOf(ans));
                    temp.setText(String.valueOf(ans));
                    break;
                case 4:
                    ans = Math.round((num * Double.parseDouble(equationBox.getText())) * 10000.0) / 10000.0;
                    equationBox.setText(String.valueOf(ans));
                    temp.setText(String.valueOf(ans));
                    break;
                case 5:
                    if (Double.parseDouble(equationBox.getText()) == 0){
                        equationBox.setText("Infinity");
                        temp.setText("ERROR");
                    }else {
                        ans = Math.round((num / Double.parseDouble(equationBox.getText())) * 10000.0) / 10000.0;
                        equationBox.setText(String.valueOf(ans));
                        temp.setText(String.valueOf(ans));
                    }
                    break;
            }
        }
    }
    private static boolean isOperator(char c){
        /* Checks if the character is operator or not*/
        return (c == '+') || (c == '-') || (c == '*') || (c == '/') || (c == '^');
    }
}


public class calculator {
    public static void main(String[] args) {
        new window();
    }
}
