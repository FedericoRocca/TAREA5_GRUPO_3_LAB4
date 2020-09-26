package frames;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import paneles.AgregarPersona;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.JToggleButton;
import java.awt.Color;

public class Inicial extends JFrame
{
    
    private JPanel contentPane;
    private JMenuBar menuBar;
    private JMenu mnPersona;
    private JMenuItem mntmAgregar;
    private JMenuItem mntmEliminar;
    private JMenuItem mntmModificar;
    private JMenuItem mntmListar;
    
    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                try
                {
                    Inicial frame = new Inicial();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }
    
    public Inicial()
    {
        setTitle("TP5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 500, 400);
        
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        
        mnPersona = new JMenu("Persona");
        menuBar.add(mnPersona);
        
        mntmAgregar = new JMenuItem("Agregar");
        mntmAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Opción de menú AGREGAR PERSONA
                contentPane.removeAll();
                AgregarPersona paneNuevaPersona = new AgregarPersona();
                contentPane.add(paneNuevaPersona);
                contentPane.revalidate();
                contentPane.repaint();
            }
        });

        mnPersona.add(mntmAgregar);
        
        mntmEliminar = new JMenuItem("Eliminar");
        mnPersona.add(mntmEliminar);
        
        mntmModificar = new JMenuItem("Modificar");
        mnPersona.add(mntmModificar);
        
        mntmListar = new JMenuItem("Listar");
        mnPersona.add(mntmListar);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        setContentPane(contentPane);
        contentPane.setLayout(null);
    }
}
