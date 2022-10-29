import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textfield;
    //There will be 10 buttons for numbers in a calculator so we have
    JButton[] numberButtons = new JButton[10];

    //There will be about 8 buttons to perform our functions/operations
    JButton[] functionButtons = new JButton[9];

    //Buttons for addition, subtraction, multiplication and division
    JButton addBtn, subBtn, mulBtn, divBtn;

    //Buttons for decimal, equals, delete, clear buttons and negative number button
    JButton decBtn, eqBtn, delBtn, clrBtn, negBtn;

    //Panel to hold all of our buttons
    JPanel panel;

    Font myFont = new Font("Ink Free",Font.BOLD,30);

    //first number, second number and our result
    double num1=0,num2=0, result=0;

    //This will hold the operator for whether multiplication, division, subtraction or addition any operation that we would try to perform
    char operator;


    Calculator()
    {
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //This closes application on closing
        frame.setSize(420, 550);
        frame.setLayout(null); 
        
        //creating an text field to allow the user to enter some text
        textfield  = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        
        //creating new buttons to add them to the panel which is attached to the frame
        addBtn = new JButton("+");
        subBtn = new JButton("-");
        mulBtn = new JButton("*");
        divBtn = new JButton("/");
        decBtn = new JButton(".");
        eqBtn  = new JButton("=");
        delBtn = new JButton("Delete");
        clrBtn = new JButton("Clear");
        negBtn = new JButton("(-)");
        
        functionButtons[0] = addBtn;
        functionButtons[1] = subBtn;
        functionButtons[2] = mulBtn;
        functionButtons[3] = divBtn;
        functionButtons[4] = decBtn;
        functionButtons[5] = eqBtn;
        functionButtons[6] = delBtn;
        functionButtons[7] = clrBtn;
        functionButtons[8] = negBtn;


        for(int i=0;i<9;i++)
        {
        	functionButtons[i].addActionListener(this);
        	functionButtons[i].setFont(myFont);
        	functionButtons[i].setFocusable(false);
        	
        }
        
        for(int i=0;i<10;i++)
        {
        	numberButtons[i] = new JButton(String.valueOf(i));
        	numberButtons[i].addActionListener(this);
        	numberButtons[i].setFont(myFont);
        	numberButtons[i].setFocusable(false);
        	
        }
        negBtn.setBounds(50,430,100,50); //The placement of the negative button
        delBtn.setBounds(150,430,100,50); //The placement of the delete button
        clrBtn.setBounds(250,430,100,50); //The placement of the clear button
        
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(4,4,10,10));
//        panel.setBackground(Color.GRAY);
        
        //adding number buttons and the operation from left to right
        //Row1
        panel.add(numberButtons[1]); 
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addBtn);
        
        //Row2
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subBtn);
        
        //Row3
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulBtn);
        
        //Row4
        panel.add(decBtn);
        panel.add(numberButtons[0]);
        panel.add(eqBtn);
        panel.add(divBtn);
        
        frame.add(panel); //Adding the panel in our frame to allow our buttons to be visible
        frame.add(negBtn); //Adding negative button to our frame

        frame.add(delBtn); //Adding delete button to our frame
        frame.add(clrBtn); //Adding clear button to our frame

        
        frame.add(textfield);
        frame.setVisible(true);  //This sets the frame to be visible
        }
    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
    
	@Override

    public void actionPerformed(ActionEvent e)
    {
		//This code allows the action listener to take user click for numbers 
		//and paste it on our app
		
		for(int i=0;i<10;i++)
		{
			if(e.getSource()== numberButtons[i])
			{
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		
		//Action Listener for Decimal Button
		if(e.getSource()==decBtn)
		{
			textfield.setText(textfield.getText().concat("."));
		}
		
		//Action Listener for Add Button
		if(e.getSource()==addBtn)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator =  '+';
			textfield.setText("");
		}

		//Action Listener for Subtract Button
		if(e.getSource()==subBtn)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator =  '-';
			textfield.setText("");
		}
		
		//Action Listener for Multiplication Button
		if(e.getSource()==mulBtn)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator =  '*';
			textfield.setText("");
		}
		
		//Action Listener for Divide Button
		if(e.getSource()==divBtn)
		{
			num1 = Double.parseDouble(textfield.getText());
			operator =  '/';
			textfield.setText("");
		}
		
		//Action Listener for equals button
		if(e.getSource()==eqBtn)
		{
			num2 = Double.parseDouble(textfield.getText());
			
			switch(operator) 
			{
			case '+': 
				result = num1 + num2;
				break;
			
			case '-': 
				result = num1 - num2;
				break;	
				
			case '*': 
				result = num1 * num2;
				break;
				
			case '/': 
				result = num1 * num2;
				break;	
				
			}
			
			textfield.setText(String.valueOf(result));
			num1 = result;
		}
		
		//The clear button clears the entire user number entered
		if(e.getSource()==clrBtn)
		{
			textfield.setText("");
		}
		
		//delete button clears the last button entered by the user
		if(e.getSource()==delBtn)
		{
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0; i<string.length()-1;i++)
			{
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
		
		if(e.getSource()==negBtn)
		{
			double temp = Double.parseDouble(textfield.getText());
			temp = temp*(-1);
			textfield.setText(String.valueOf(temp));
		}
    }
}


