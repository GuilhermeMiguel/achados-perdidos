package util_pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class gerarPdf {

	//Alterar classe modelo de devolucao para pegar categoria e passar aqui para o método de gerar relatório
	public void geraPdf(String nome, String documento, String data) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C://PDF_LinhaCodigo.pdf"));
			document.open();
			// adicionando um parágrafo ao documento
			document.add(new Paragraph("O aluno" +nome+ "portador do documento:" +documento+
					"comprova que retirou seu objeto na seguinte data:" +data));
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		}

		catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}

}
