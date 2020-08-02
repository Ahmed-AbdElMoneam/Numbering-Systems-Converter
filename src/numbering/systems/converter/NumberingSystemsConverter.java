package numbering.systems.converter;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.HPos;

//Our class "NumberingSystemsConverter" inherits Application class.
public class NumberingSystemsConverter extends Application {
    /*Here I will declare some nodes. I will declare/create 5 textfields, one
    of them will receive the input and others for output. and also I declared
    5 labels to describe them and finally I will create 4 buttons for the main
    4 numbering systems.*/
    Label lblnum = new Label("Please Enter the number you want to convert:\n"
            + "(Use capital letters in Hexadecimal numbers)");
    TextField txtnum = new TextField();
    
    Button btnBin = new Button("Check Binary & Convert");
    Button btnOct = new Button("Check Octal & Convert");
    Button btnDec = new Button("Check Decimal & Convert");
    Button btnHex = new Button("Check Hexadecimal & Convert");
    
    Label lblBin = new Label("The number in Binary");
    TextField txtBin = new TextField();
    
    Label lblOct = new Label("The number in Octal");
    TextField txtOct = new TextField();
    
    Label lblDec = new Label("The number in Decimal");
    TextField txtDec = new TextField();
    
    Label lblHex = new Label("The number in Hexadecimal");
    TextField txtHex = new TextField();
    
    /*This is the function which will be executed
    after clicking "Check Binary & Convert".*/
    void Binaryinput(){
        /*Two variables of long data type to
        hold the decimal and octal number after conversion.*/
        long Octnum = 0 , Decnum = 0;
        /*This flag is to determine if the number is represented correctly
        or there is a mistake in the number bits.*/
        boolean flag = false;
        /*These two arrays hold the bits of the number in binary and
        octal representation.*/
        int [] binary_digits = new int[32];
        int [] octal_digits = new int[32];
        /*These two long variables get the binary number from input textfield.
        the first one will be used to generate the binary bits
        and the second will be used to set the number in the binary textfield.*/
        long num = Long.parseLong(txtnum.getText());
        long copy1_num = Long.parseLong(txtnum.getText());
        /*This for loop is used to check that the number is represented in
        the binary form correctly. So, we will store the bits (remainder of
        sequential division by 10) of the binary number in an array and divide by 
        10 sequentially also.*/
        for(int i = 0 ; i < binary_digits.length ; i++){
            binary_digits[i] = (int) (num % 10);
            num /= 10;
            /*If it is not represented correctly these messages will be shown in
            the textfields. as this if condition checks if the binary bit is
            more than one. and there is also a flag.*/
            if(binary_digits[i] > 1){
                txtBin.setText("The number is incorrect, Please enter a Binary one.");
                txtOct.setText("The number is incorrect, Please enter a Binary one.");
                txtDec.setText("The number is incorrect, Please enter a Binary one.");
                txtHex.setText("The number is incorrect, Please enter a Binary one.");
                flag = true;
                break;
            }
        }
        for(int i = 0 ; i < 1 ; i++){
            /*This if condition checks the value of the flag as if it is true
            there will be a break statement which will go to the end of the function.*/
            if(true == flag){
                break;
            }
            //Here, we will copy the content of the input textfield to the binary one.
            txtBin.setText(String.format("%d", copy1_num));
            /*This for loop is used to convert the binary bits to decimal number 
            by multiplying the bit to 2 to the power x. As x is the order of the 
            bit in array.*/
            for(int x = binary_digits.length ; x > 0 ; x--){
                Decnum += binary_digits[x - 1] * Math.pow(2, x - 1);
            }
            //Here, we will set the decimal textfield to the decimal number converted.
            txtDec.setText(String.format("%d", Decnum));
            /*Then we will get the decimal number from the decimal textfield to use
            it while generating the hexadecimal representation of the number as the 
            Decnum variable will change after the next for loop.*/
            long copy_Decnum = Long.parseLong(txtDec.getText());
            /*This for loop will generate the octal number by the sequential division
            by 8 and this will generate the bits of the octal representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            y. As y is the order of the bit in the array.*/
            for(int y = 0 ; Decnum > 0 ; y++){
                octal_digits[y] = (int) (Decnum % 8);
                Decnum /= 8;  
                Octnum += Math.pow(10 , y) * octal_digits[y];
            }
            //Here, we will set the Octal textfield to the octal number converted.
            txtOct.setText(String.format("%d", Octnum));
            /*Here we will use the (toHexString()) to generate the hexadecimal number
            automatically (with uppercase letters) then we will set the result to
            the hexadecimal textfield.*/
            String Hexnum = Long.toHexString(copy_Decnum).toUpperCase();
            txtHex.setText(String.format("%s", Hexnum));
        }
    }
    
    /*This is the function which will be executed
    after clicking "Check Octal & Convert".*/
    void Octalinput(){
        /*Two variables of long data type to
        hold the decimal and binary number after conversion.*/
        long Binnum = 0 , Decnum = 0;
        /*This flag is to determine if the number is represented correctly
        or there is a mistake in the number bits.*/
        boolean flag = false;
        /*These two arrays hold the bits of the number in binary and
        octal representation.*/
        int [] binary_digits = new int[32];
        int [] octal_digits = new int[32];
        /*These two long variables get the octal number from input textfield.
        the first one will be used to generate the octal bits
        and the second will be used to set the number in the octal textfield.*/
        long num = Long.parseLong(txtnum.getText());
        long copy1_num = Long.parseLong(txtnum.getText());
        /*This for loop is used to check that the number is represented in
        the octal form correctly. So, we will store the bits (remainder of
        sequential division by 10) of the octal number in an array and divide by 
        10 sequentially also.*/
        for(int i = 0 ; i < octal_digits.length ; i++){
            octal_digits[i] = (int) (num % 10);
            num /= 10;
            /*If it is not represented correctly these messages will be shown in
            the textfields. as this if condition checks if the octal bit is
            more than seven. and there is also a flag.*/
            if(octal_digits[i] > 7){
                txtBin.setText("The number is incorrect, Please enter an Octal one.");
                txtOct.setText("The number is incorrect, Please enter an Octal one.");
                txtDec.setText("The number is incorrect, Please enter an Octal one.");
                txtHex.setText("The number is incorrect, Please enter an Octal one.");
                flag = true;
                break;
            }
        }
        for(int i = 0 ; i < 1 ; i++){
            /*This if condition checks the value of the flag as if it is true
            there will be a break statement which will go to the end of the function.*/
            if(true == flag){
                break;
            }
            //Here, we will copy the content of the input textfield to the octal one.
            txtOct.setText(String.format("%d", copy1_num));
            /*This for loop is used to convert the octal bits to decimal number 
            by multiplying the bit to 8 to the power x. As x is the order of the 
            bit in array.*/
            for(int x = octal_digits.length ; x > 0 ; x--){
                Decnum += octal_digits[x - 1] * Math.pow(8, x - 1);
            }
            //Here, we will set the decimal textfield to the decimal number converted.
            txtDec.setText(String.format("%d", Decnum));
            /*Then we will get the decimal number from the decimal textfield to use
            it while generating the hexadecimal representation of the number as the 
            Decnum variable will change after the next for loop.*/
            long copy_Decnum = Long.parseLong(txtDec.getText());
            /*This for loop will generate the binary number by the sequential division
            by 2 and this will generate the bits of the binary representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            y. As y is the order of the bit in the array.*/
            for(int y = 0 ; Decnum > 0 ; y++){
                binary_digits[y] = (int) (Decnum % 2);
                Decnum /= 2;  
                Binnum += binary_digits[y] * Math.pow(10 , y);
            }
            //Here, we will set the Binary textfield to the binary number converted.           
            txtBin.setText(String.format("%d", Binnum));
            /*Here we will use the (toHexString()) to generate the hexadecimal number
            automatically (with uppercase letters) then we will set the result to
            the hexadecimal textfield.*/
            String Hexnum = Long.toHexString(copy_Decnum).toUpperCase();
            txtHex.setText(String.format("%s", Hexnum));
        }
    }
    
    /*This is the function which will be executed
    after clicking "Check Decimal & Convert".*/
    void Decimalinput(){
        /*Two variables of long data type to
        hold the octal and binary number after conversion.*/
        long Binnum = 0 , Octnum = 0;
        /*This flag is to determine if the number is represented correctly
        or there is a mistake in the number bits.*/
        boolean flag = false;
        /*These three arrays hold the bits of the number in binary, decimal and
        octal representation.*/
        int [] binary_digits = new int[32];
        int [] octal_digits = new int[32];
        int [] decimal_digits = new int[32];
        /*These four long variables get the decimal number from input textfield.
        the first one will be used to generate the decimal bits.
        the second will be used to set the number in the decimal textfield and generate
        the binary bits.
        the third will be used to generate the octal bits.
        the fourth will be used to generate the hexadecimal bits.*/
        long num = Long.parseLong(txtnum.getText());
        long copy1_num = Long.parseLong(txtnum.getText());
        long copy2_num = Long.parseLong(txtnum.getText());
        long copy3_num = Long.parseLong(txtnum.getText());
        /*This for loop is used to check that the number is represented in
        the decimal form correctly. So, we will store the bits (remainder of
        sequential division by 10) of the decimal number in an array and divide by 
        10 sequentially also.*/
        for(int i = 0 ; i < decimal_digits.length ; i++){
            decimal_digits[i] = (int) (num % 10);
            num /= 10;
            /*If it is not represented correctly these messages will be shown in
            the textfields. as this if condition checks if the decimal bit is
            more than nine. and there is also a flag.*/
            if(decimal_digits[i] > 9){
                txtBin.setText("The number is incorrect, Please enter a Decimal one.");
                txtOct.setText("The number is incorrect, Please enter a Decimal one.");
                txtDec.setText("The number is incorrect, Please enter a Decimal one.");
                txtHex.setText("The number is incorrect, Please enter a Decimal one.");
                flag = true;
                break;
            }
        }
        for(int i = 0 ; i < 1 ; i++){
            /*This if condition checks the value of the flag as if it is true
            there will be a break statement which will go to the end of the function.*/
            if(true == flag){
                break;
            }
            //Here, we will copy the content of the input textfield to the decimal one.
            txtDec.setText(String.format("%d", copy1_num));
            /*This for loop will generate the binary number by the sequential division
            by 2 and this will generate the bits of the binary representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            x. As x is the order of the bit in the array.*/
            for(int x = 0 ; copy1_num > 0 ; x++){
                binary_digits[x] = (int) (copy1_num % 2);
                copy1_num /= 2;  
                Binnum += binary_digits[x] * Math.pow(10 , x);
            }
            //Here, we will set the Binary textfield to the binary number converted.
            txtBin.setText(String.format("%d", Binnum));
            /*This for loop will generate the octal number by the sequential division
            by 8 and this will generate the bits of the octal representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            y. As y is the order of the bit in the array.*/
            for(int y = 0 ; copy2_num > 0 ; y++){
                octal_digits[y] = (int) (copy2_num % 8);
                copy2_num /= 8;
                Octnum += octal_digits[y] * Math.pow(10 , y);
            }
            //Here, we will set the Octal textfield to the octal number converted.
            txtOct.setText(String.format("%d", Octnum));
            /*Here we will use the (toHexString()) to generate the hexadecimal number
            automatically (with uppercase letters) then we will set the result to
            the hexadecimal textfield.*/
            String Hexnum = Long.toHexString(copy3_num).toUpperCase();
            txtHex.setText(String.format("%s", Hexnum));
        }
    }
    
    /*This is the function which will be executed
    after clicking "Check Hexadecimal & Convert".*/
    void Hexadecimalinput(){
        /*Two variables of long data type to
        hold the octal and binary number after conversion.*/
        long Binnum = 0 , Octnum = 0;
        /*This flag is to determine if the number is represented correctly
        or there is a mistake in the number bits.*/
        int flag = 0;
        /*This array of characters will identify the allowed characters in
        the hexadecimal string entered in the input textfield.*/
        char [] hexadecimal_digits = 
            {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        /*These two arrays hold the bits of the number in binary and
        octal representation.*/
        int [] binary_digits = new int[32];
        int [] octal_digits = new int[32];
        /*These two for loops will determine if the characters of the hexadecimal string
        are found in "hexadecimal_digits" array or not.*/
        for(int j = 0 ; j < txtnum.getText().length() ; j++){
            for(int i = 0 ; i < hexadecimal_digits.length ; i++){
                //if the character is found in the array the flag will increse.
                if(txtnum.getText().charAt(j) == hexadecimal_digits[i]){
                    flag++;
                    break; 
                }
            }
        }
        /*if the value of the flag is less than the number of characters this means
        that there is a character which is not a hexadecimal character and these 
        messages will be shown.*/
        if(txtnum.getText().length() > flag){
            txtBin.setText("The number is incorrect, Please enter a Hexadecimal one.");
            txtOct.setText("The number is incorrect, Please enter a Hexadecimal one.");
            txtDec.setText("The number is incorrect, Please enter a Hexadecimal one.");
            txtHex.setText("The number is incorrect, Please enter a Hexadecimal one.");
        }
        /*if the value of the flag is the same as the number of characters this means that
        the number is already a hexadecimal number.*/
        else if(txtnum.getText().length() == flag){
            //Here, we will copy the content of the input textfield to the Hexadecimal one.
            txtHex.setText(String.format("%s", txtnum.getText()));
            /*Here, i will convert the entered hexadecimal value to a decimal one
            then i will set it on the decimal textfield.*/
            long Decnum = Long.parseLong(txtnum.getText() , 16);
            txtDec.setText(String.format("%d", Decnum));
            //Here, i will take a copy of the decimal number.
            long copy1_Decnum = Long.parseLong(txtnum.getText() , 16);
            /*This for loop will generate the binary number by the sequential division
            by 2 and this will generate the bits of the binary representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            x. As x is the order of the bit in the array.*/
            for(int x = 0 ; copy1_Decnum > 0 ; x++){
                binary_digits[x] = (int) (copy1_Decnum % 2);
                copy1_Decnum /= 2;  
                Binnum += binary_digits[x] * Math.pow(10 , x);
            }
            //Here, we will set the Binary textfield to the binary number converted.
            txtBin.setText(String.format("%d", Binnum));
            //Here, i will take another copy of the decimal number.
            long copy2_Decnum = Long.parseLong(txtnum.getText() , 16);
            /*This for loop will generate the octal number by the sequential division
            by 8 and this will generate the bits of the octal representation. and to
            display the whole number we will multiply each bit by 10 to the power of
            y. As y is the order of the bit in the array.*/
            for(int y = 0 ; copy2_Decnum > 0 ; y++){
                octal_digits[y] = (int) (copy2_Decnum % 8);
                copy2_Decnum /= 8;
                Octnum += octal_digits[y] * Math.pow(10 , y);
            }
            //Here, we will set the Octal textfield to the octal number converted.
            txtOct.setText(String.format("%d", Octnum));
        }
        
    }
    //I will override "start" method.
    @Override
    public void start(Stage primaryStage) {
        /*I will create a grid pane and i will modify its insets, put it
        in center and also adjust the horizontal and vertical gap between nodes.*/
        GridPane G = new GridPane();
        G.setPadding(new Insets(5 , 10 , 10 , 10));
        G.setHgap(30);
        G.setVgap(10);
        G.setAlignment(Pos.CENTER);
        
        /*I will add four labels and adjust their alignment and four textfields
        which i will modify their insets and their size on the gridpane.*/
        G.add(lblBin , 1 , 1);
        G.setHalignment(lblBin , HPos.LEFT);
        
        G.add(txtBin , 2 , 1);
        txtBin.setPadding(new Insets(7 , 3 , 7 , 3));
        txtBin.setPrefSize(350, 25);
        
        G.add(lblOct , 1 , 2);
        G.setHalignment(lblOct , HPos.LEFT);
        
        G.add(txtOct , 2 , 2);
        txtOct.setPadding(new Insets(7 , 3 , 7 , 3));
        txtOct.setPrefSize(350, 25);
        
        G.add(lblDec , 1 , 3);
        G.setHalignment(lblDec , HPos.LEFT);
        
        G.add(txtDec , 2 , 3);
        txtDec.setPadding(new Insets(7 , 3 , 7 , 3));
        txtDec.setPrefSize(350, 25);
        
        G.add(lblHex , 1 , 4);
        G.setHalignment(lblHex , HPos.LEFT);
        
        G.add(txtHex , 2 , 4);
        txtHex.setPadding(new Insets(7 , 3 , 7 , 3));
        txtHex.setPrefSize(350, 25);
        
        /*Also, i will add 2 HBoxes for the buttons and the input textfield
        and its label and i will adjust their position.*/
        HBox H1 = new HBox(20);
        H1.getChildren().addAll(lblnum , txtnum);
        txtnum.setPrefSize(350, 25);
        H1.setAlignment(Pos.CENTER);
        
        HBox H2 = new HBox(20);
        H2.getChildren().addAll(btnBin , btnOct , btnDec , btnHex);
        H2.setAlignment(Pos.CENTER);
        
        /*Here, I create VBox to add the two HBoxes and the gridpane on it.
        and i will position it in the center.*/
        VBox V = new VBox(30);
        V.getChildren().addAll(H1 , H2 , G);
        V.setAlignment(Pos.CENTER);
        
        //Here, i will put the HBox on the scene. 
        Scene S = new Scene(V, 800, 350);
        
        /*I will set the methods which will be executed when pressing any of the
        four methods on action.*/
        btnBin.setOnAction(e -> Binaryinput());
        btnOct.setOnAction(e -> Octalinput());
        btnDec.setOnAction(e -> Decimalinput());
        btnHex.setOnAction(e -> Hexadecimalinput());
        
        /*Finally, I will set the title of the stage and set the scene in the stage
        also and show it.*/
        primaryStage.setTitle("Numbering Systems Checker & Converter");
        primaryStage.setScene(S);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    } 
}
