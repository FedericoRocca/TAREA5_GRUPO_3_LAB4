package principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class Ventana extends JFrame
{
    
    private JPanel contentPane;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Ventana frame = new Ventana();
                    frame.setVisible(true);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    /**
     * Create the frame.
     */
    public Ventana()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        JMenu mnPersona = new JMenu("Persona");
        menuBar.add(mnPersona);
        
        JMenuItem mntmAgregar = new JMenuItem("Agregar");
        mnPersona.add(mntmAgregar);
        
        JMenuItem mntmEliminar = new JMenuItem("Eliminar");
        mnPersona.add(mntmEliminar);
        
        JMenuItem mntmModificar = new JMenuItem("Modificar");
        mnPersona.add(mntmModificar);
        
        JMenuItem mntmListar = new JMenuItem("Listar");
        mnPersona.add(mntmListar);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
}
