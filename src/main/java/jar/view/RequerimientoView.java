package jar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import jar.controller.RequerimientoController;
import jar.model.vo.AsesorPorCiudadVo;
import jar.model.vo.CompraPorProveedorVo;
import jar.model.vo.ProyectoCasaCampestreVo;

public class RequerimientoView extends JFrame {

    public static final RequerimientoController controlador = new RequerimientoController();

    //Mitigar errores de instancias 
    private static final long serialVersionUID = 1L;
    private JPanel contentPanel;
    private JTextArea textArea;

    public RequerimientoView(){
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 100, 800,650);
        
        contentPanel = new JPanel();
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPanel);
        contentPanel.setLayout(null);

        JLabel lbTitulo = new JLabel("---- Reto 5");
        lbTitulo.setBounds(28,6, 61, 16);

        contentPanel.add(lbTitulo);

        //Dimension del contenido dentro de la ventana 
        JScrollPane scrollPane = new JScrollPane();

        scrollPane.setBounds(28, 70, 737, 455);
        contentPanel.add(scrollPane);

        //Proporcionar una vista de un componente 
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);

        //Boton 1 - Informe 1
        JButton btnConsulta1 = new JButton("Informe 1");
        btnConsulta1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                informe1();
                
            }
                
        });

        
        btnConsulta1.setBounds(28, 537, 113, 29);
        contentPanel.add(btnConsulta1);


        //Boton 2 Informe 2
        JButton btnConsulta2 = new JButton("Informe 2");
        btnConsulta2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {

                informe2();
                
            }

        });

        btnConsulta2.setBounds(170, 537, 113 , 29);
        contentPanel.add(btnConsulta2);



        //Boton 3 informe 3
        JButton btnConsulta3 = new JButton("Informe 3");
        btnConsulta3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                informe3();
            }

        });

        btnConsulta3.setBounds(304, 537, 113 , 29);
        contentPanel.add(btnConsulta3);


        JButton btnLimpiar = new JButton("Limpiar");

        btnLimpiar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("Clic sobre el informe a generar");
                
            }

        });

        btnLimpiar.setBounds(510, 537, 113, 29);
        contentPanel.add(btnLimpiar);

    }

    public void informe1(){
        try {
            ArrayList<AsesorPorCiudadVo> registros = controlador.consultarAsesorPorCiudad();
            String salida = "**** Asesor por ciudad **** \n\nId Lider\tNombre\tPrimer Apellido\tResidencia\n\n";

            for(AsesorPorCiudadVo reg: registros){
                salida += reg.getIdLider();
                salida += "\t";
                salida += reg.getNombre();
                salida += "\t";
                salida += reg.getPrimerApellido();
                salida += "\t";
                salida += reg.getCiudadResidencia();
                salida += "\n";
                textArea.setText(salida);
            }
        } catch (Exception e) {
            System.err.println("Error inesperado..." + e.getMessage());
        }
    }


public void informe2(){
    try {
        ArrayList<ProyectoCasaCampestreVo> casas = controlador.consultarProyectoCasaCampestre();
        String salida = "**** Proyecto Casa Campestre **** \n\nId Proyecto \t Constructora \t Habitaciones \tCiudad \n\n";

        for(ProyectoCasaCampestreVo casa: casas){
            salida += casa.getIdProyecto() +  "\t ";
            salida += casa.getConstructora();
            if(casa.getConstructora().length() <= 11){
                salida += " \t\t ";
            }else{
                salida += " \t ";
            }
            salida += casa.getNumeroHabitaciones() + "\t ";
            salida += casa.getCiudad() + "\n"; 
            
        }
        textArea.setText(salida);
    } catch (Exception e) {
        System.err.println("Error inesperado..." + e.getMessage());
    }
}


public void informe3(){

    try {
        ArrayList<CompraPorProveedorVo> compras = controlador.consultarCompraPorProveedor();
        String salida = "**** Compra por Proveedor **** \n\nId Compra \t Constructora \t Banco Vinculado \n\n";

        for(CompraPorProveedorVo compra: compras){

            salida += compra.getIdCompra() + " \t";
            salida += compra.getConstructora();
            if(compra.getConstructora().length() <= 11){
                salida += " \t\t ";
            }else{
                salida += " \t ";
            }
            salida += compra.getBancoVinculado() + "\n";
            
        }
        textArea.setText(salida);
    } catch (Exception e) {
        System.err.println("Error inesperado..." + e.getMessage());
    }
}

}