/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frame;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author abdel
 */
public class jTextField {
    
	public 
	 JTextField jtf=new JTextField();
	 
	 jTextField(final TableRowSorter sorter){
		 
		 jtf.getDocument().addDocumentListener(new DocumentListener() {

				@Override
				public void insertUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					search(jtf.getText());
				}


				@Override
				public void removeUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					search(jtf.getText());
				}

				@Override
				public void changedUpdate(DocumentEvent e) {
					// TODO Auto-generated method stub
					search(jtf.getText());
				}
				
				public void search(String str)
				{
					if (str.length()==0||jtf.getText().contentEquals(" Search..."))
					{
						sorter.setRowFilter(null);
					}
					else
					{
						sorter.setRowFilter(RowFilter.regexFilter(str));
					}
				}
		 });
		 }
	 
}

 
