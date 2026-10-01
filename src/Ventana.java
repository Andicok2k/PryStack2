import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JSpinner spiNumero;
    private JButton btnCalcular;
    private JLabel lblResultado;
    private JPanel ventana;
    private Pila pila=new Pila();

    public Ventana() {
        SpinnerNumberModel snm=new SpinnerNumberModel(10,1,1000,1);
        spiNumero.setModel(snm);
        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer valor=Integer.parseInt(spiNumero.getValue().toString());
                while(valor!=0){
                    Integer residuo=valor%2;
                    pila.push(residuo);
                    valor=valor/2;
                }
                lblResultado.setText(pila.binario());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().ventana);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
