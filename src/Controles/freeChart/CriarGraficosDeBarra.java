/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles.freeChart;

import JARs.Validacoes;
import java.awt.Dimension;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CriarGraficosDeBarra {

    Validacoes val = new Validacoes();

    //Criar Dataset
    //Criar Grafico completo
    /**
     *
     * public CategoryDataset criaDataSet(ArrayList<Livro> lstProdutos) {
     * DefaultCategoryDataset dataSet = new DefaultCategoryDataset(); for (Livro
     * o : lstProdutos) { dataSet.addValue(o.getQuant(), o.getTitulo(), ""); }
     * return dataSet; }
     *
     * //Criar graficos de Barras public JFreeChart
     * creatBarChart(CategoryDataset dataSet) { JFreeChart graficoBarras =
     * ChartFactory.createBarChart("Livros e suas quantidades", "",
     * "Quantidades", dataSet, PlotOrientation.VERTICAL, true, false, false);
     * return graficoBarras; }
     *
     * public ChartPanel criarGrafico(ArrayList<Livro> lstProdutos) {
     * CategoryDataset dataset = this.criaDataSet(lstProdutos); JFreeChart
     * grafico = this.creatBarChart(dataset); ChartPanel painelDoGrafico = new
     * ChartPanel(grafico); painelDoGrafico.setPreferredSize(new Dimension(400,
     * 400)); return painelDoGrafico; }
     */
    //Criar Dataset
    public CategoryDataset criaDataSet(ArrayList<Object> lst) {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        int quant=5;
        String descr="Mangas";
        dataSet.addValue(quant,descr, "");
        return dataSet;
    }

    //Criar graficos de Barras
    public JFreeChart creatBarChart(CategoryDataset dataSet, String titulo) {
        JFreeChart graficoBarras = ChartFactory.createBarChart(
                titulo, "",
                "Quantidades",
                dataSet, 
                PlotOrientation.VERTICAL, 
                true, false, false);
        return graficoBarras;
    }

    public ChartPanel criarGrafico(ArrayList<Object> lstProdutos, String titulo) {
        CategoryDataset dataset = this.criaDataSet(lstProdutos);
        JFreeChart grafico = this.creatBarChart(dataset, titulo);
        ChartPanel painelDoGrafico = new ChartPanel(grafico);
        painelDoGrafico.setPreferredSize(new Dimension(400, 400));
        return painelDoGrafico;
    }
  

}
