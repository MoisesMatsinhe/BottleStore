package Controles.freeChart;

import JARs.Componentes;
import JARs.Validacoes;
import Modelos.Venda;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class VendaBar extends JPanel{

    Validacoes val = new Validacoes();
    Componentes c=new Componentes();
    public VendaBar() {
        setOpaque(false);
        c.mkGridPNL(this, 200, 200, 0, 0);
    }
 
    public ChartPanel criarGrafico(ArrayList<Venda> lst, String titulo) {
        CategoryDataset dataset = this.stValues(lst);
        JFreeChart grafico = this.mkBarras(dataset, titulo);
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize(new Dimension(400, 400));
        return painelDoGrafico;
    }
    
    //Criar graficos de Barras
    public JFreeChart mkBarras(CategoryDataset dataSet, String titulo) {
        JFreeChart graficoBarras = ChartFactory.createBarChart(
                titulo, "",
                "Quantidades",
                dataSet, 
                PlotOrientation.VERTICAL, 
                true, false, false);
        return graficoBarras;
    }
    
    public CategoryDataset stValues(ArrayList<Venda> lst) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int quant=5;
        String descr="Mangas";
        dataSet.addValue(quant,descr, "");
        return dataSet;
    }


  

}
