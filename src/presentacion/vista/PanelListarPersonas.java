package presentacion.vista;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import daolmpl.PersonaDaolmpl;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;

public class PanelListarPersonas extends JPanel {
	
	private JTable table;
	private DefaultTableModel modelPersonas;
	private String[] nombreColumnas = {"Nombre","Apellido","Dni"};
	/**
	 * Create the panel.
	 */

	 public PanelListarPersonas() {
			
			super();
			initialize();
	}
	 
	 private void initialize() 
	 {
			
		this.setBounds(100, 100, 514, 455);
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 489, 282);
		this.add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(15, 30, 444, 179);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		ResultSet rs = PersonaDaolmpl.getTabla("SELECT Nombre,Apellido,Dni FROM Personas");
		
		modelPersonas.setColumnIdentifiers(new Object[] {"Nombre","Apellido","Dni"});
		
		table = new JTable(modelPersonas);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(103);
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(table);
		
		try {
			
			while(rs.next()) {
				
				modelPersonas.addRow(new Object[] {rs.getString("Nombre"),rs.getString("Apellido"),rs.getString("Dni")});
				
			}
			
			table.setModel(modelPersonas);
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	
	}
	
		public void show()
		{
			this.setVisible(true);
		}
}
