package paneles;

import javax.swing.JPanel;
import javax.swing.JTextPane;
import java.awt.FlowLayout;
import javax.swing.JTree;
import javax.swing.border.TitledBorder;

import dominio.Persona;
import dominio.PersonaDao;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarPersona extends JPanel
{
    private JTextField txfNombre;
    private JTextField txfApellido;
    private JTextField txfDNI;
    
    public AgregarPersona()
    {
        setBackground(Color.LIGHT_GRAY);
        setLayout(null);
        setBounds(0, 0, 332, 115);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 11, 46, 14);
        add(lblNombre);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(10, 36, 46, 14);
        add(lblApellido);
        
        JLabel lblDni = new JLabel("DNI");
        lblDni.setBounds(10, 61, 46, 14);
        add(lblDni);
        
        JButton btnAceptar = new JButton("Aceptar");
        btnAceptar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se quiere guardar la persona, validamos datos
                if( txfNombre.getText().equals("") )
                {
                    JOptionPane.showMessageDialog(null, "Debés ingresar un nombre", "Faltó el nombre!", JOptionPane.OK_OPTION);
                } 
                else if( txfApellido.getText().equals("") )
                {
                    JOptionPane.showMessageDialog(null, "Debés ingresar un apellido", "Faltó el apellido!", JOptionPane.OK_OPTION);
                } 
                else if( txfDNI.getText().equals("") )
                {
                    JOptionPane.showMessageDialog(null, "Debés ingresar un DNI", "Faltó el DNI!", JOptionPane.OK_OPTION);
                }
                
                // Validamos largos
                if( txfNombre.getText().length() > 45 )
                {
                    JOptionPane.showMessageDialog(null, "El nombre ingresado es demasiado largo", "Nombre inválido!", JOptionPane.OK_OPTION);
                }
                else if( txfApellido.getText().length() > 45 )
                {
                    JOptionPane.showMessageDialog(null, "El apellido ingresado es demasiado largo", "Apellido inválido!", JOptionPane.OK_OPTION);
                }
                
                int dniIngresado = 0;
                try
                {
                    Integer.parseInt(txfDNI.getText());
                    dniIngresado = Integer.parseInt(txfDNI.getText());
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Debés ingresar un DNI válido", "DNI incorrecto!", JOptionPane.OK_OPTION);
                }
                
                if( dniIngresado <= 0 )
                {
                    JOptionPane.showMessageDialog(null, "El DNI ingresado es inválido", "Apellido inválido!", JOptionPane.OK_OPTION);
                }
                
                // Llegamos hasta acá, las validaciones resultaron todas OK, guardamos en la base
                Persona persona = new Persona();
                persona.setNombre(txfNombre.getText());
                persona.setApellido(txfApellido.getText());
                persona.setDni(dniIngresado);
                
                PersonaDao ddbbGateway = new PersonaDao();
                if( ddbbGateway.crearPersona(persona) > 0 )
                {
                    JOptionPane.showMessageDialog(null, "Persona dada de alta correctamente", "Persona dada de alta!", JOptionPane.OK_OPTION);
                    txfNombre.setText("");
                    txfApellido.setText("");
                    txfDNI.setText("");
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Hubo un error al dar de alta la persona", "Contacte al administrador", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAceptar.setBounds(10, 86, 89, 23);
        add(btnAceptar);
        
        txfNombre = new JTextField();
        txfNombre.setBounds(66, 8, 260, 20);
        add(txfNombre);
        txfNombre.setColumns(10);
        
        txfApellido = new JTextField();
        txfApellido.setBounds(66, 33, 260, 20);
        add(txfApellido);
        txfApellido.setColumns(10);
        
        txfDNI = new JTextField();
        txfDNI.setBounds(66, 58, 260, 20);
        add(txfDNI);
        txfDNI.setColumns(10);
    }
}
