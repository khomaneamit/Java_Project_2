import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.spire.pdf.PdfDocument;
import com.spire.pdf.FileFormat;
import java.io.*;

class pdf extends JFrame implements ActionListener
{
	JLabel l1;
	JTextField t1;
	JButton b1,b2;
	String[] str;
	
	pdf()
	{
		setTitle("pdf to word converter");
		setSize(500,200);
		setLocation(250,250);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		l1 = new JLabel("Pdf To Word Converter");
		t1 = new JTextField();
		b1 = new JButton("load file");
		b2 = new JButton("convert");
		
		add(l1);
			l1.setBounds(50,20,200,25);
		add(t1);
			t1.setBounds(50,70,200,25);
		add(b1);
			b1.setBounds(275,70,150,25);
		add(b2);
			b2.setBounds(50,120,150,25);
			
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			JFileChooser fc = new JFileChooser();
			fc.setDialogType(JFileChooser.FILES_ONLY);
			int r = fc.showOpenDialog(null);
			if(r==JFileChooser.APPROVE_OPTION)
			{
				str = fc.getSelectedFile().getName().split("[.]");
				String path = fc.getSelectedFile().toString();
				t1.setText(path);
			}
		}
		
		if(e.getSource()==b2)
		{
			PdfDocument pd = new PdfDocument();
			pd.loadFromFile(t1.getText());
			pd.saveToFile(str[0]+".docx",FileFormat.DOCX);
			pd.close();
			File fp = new File(str[0]+".docx");
			if(fp.exists())
			{
				JOptionPane.showMessageDialog(null,"file converted successfully");
			}
		}
	}
	
	public static void main(String []args)
	{
		new pdf();
	}
}