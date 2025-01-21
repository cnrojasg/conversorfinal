import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Convertdivisa {
    public static void main(String[] args) {
        // Tasas de conversión (puedes actualizar estas tasas según el mercado actual)
        double tasaDolarAPesoChileno = 817.5;
        double tasaDolarAPesoArgentino = 98.5;
        double tasaPesoChilenoADolar = 1 / 817.5;
        double tasaPesoArgentinoADolar = 1 / 98.5;

        // Crear la ventana principal
        JFrame frame = new JFrame("Conversor de Divisas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);

        // Etiqueta para el título
        JLabel labelTitulo = new JLabel("Conversor de Divisas");
        labelTitulo.setBounds(130, 10, 200, 30);
        frame.add(labelTitulo);

        // ComboBox para seleccionar la conversión
        String[] opciones = {
                "Dólar a Peso Chileno",
                "Dólar a Peso Argentino",
                "Peso Chileno a Dólar",
                "Peso Argentino a Dólar"
        };
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setBounds(100, 50, 200, 30);
        frame.add(comboBox);

        // Campo de texto para la cantidad
        JLabel labelCantidad = new JLabel("Cantidad:");
        labelCantidad.setBounds(50, 100, 100, 30);
        frame.add(labelCantidad);

        JTextField textCantidad = new JTextField();
        textCantidad.setBounds(150, 100, 200, 30);
        frame.add(textCantidad);

        // Botón para convertir
        JButton botonConvertir = new JButton("Convertir");
        botonConvertir.setBounds(150, 150, 100, 30);
        frame.add(botonConvertir);

        // Etiqueta para mostrar el resultado
        JLabel labelResultado = new JLabel("Resultado: ");
        labelResultado.setBounds(50, 200, 300, 30);
        frame.add(labelResultado);

        // Acción del botón
        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double cantidad = Double.parseDouble(textCantidad.getText());
                    double resultado = 0;
                    String opcion = (String) comboBox.getSelectedItem();

                    switch (opcion) {
                        case "Dólar a Peso Chileno":
                            resultado = cantidad * tasaDolarAPesoChileno;
                            break;
                        case "Dólar a Peso Argentino":
                            resultado = cantidad * tasaDolarAPesoArgentino;
                            break;
                        case "Peso Chileno a Dólar":
                            resultado = cantidad * tasaPesoChilenoADolar;
                            break;
                        case "Peso Argentino a Dólar":
                            resultado = cantidad * tasaPesoArgentinoADolar;
                            break;
                    }

                    labelResultado.setText("Resultado: " + resultado);
                } catch (NumberFormatException ex) {
                    labelResultado.setText("Por favor, ingresa un número válido.");
                }
            }
        });

        // Mostrar la ventana
        frame.setVisible(true);
    }
}

