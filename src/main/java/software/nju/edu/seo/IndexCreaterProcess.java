package software.nju.edu.seo;

import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import software.nju.edu.domain.dao.BookDao;
import software.nju.edu.domain.entity.Book;
import software.nju.edu.domain.impl.BookDaoImpl;

public class IndexCreaterProcess {
	
	public void createIndex() throws Exception {
		// query book list
		BookDao bookdao = new BookDaoImpl();
		List<Book> bookList = bookdao.queryBookList();
		
		List<Document> docList = new ArrayList<Document>();
		Document document;
		for (Book book: bookList) {
			document = new Document();
			// book id
			Field bid = new TextField("bid", book.getBid(), Field.Store.YES);
			// book title
			Field title = new TextField("title", book.getTitle(), Field.Store.YES);
			// book author
			Field author = new TextField("author", book.getAuthor(), Field.Store.YES);
			// book price
			Field price = new TextField("price", Float.toString(book.getPrice()), Field.Store.YES);
			// book exchange points
			Field points = new TextField("points", Integer.toString(book.getPoints()), Field.Store.YES);
			// book discount
			Field discount = new TextField("discount", Float.toString(book.getDiscount()), Field.Store.YES);
			// book picture name
			Field picname = new TextField("picname", book.getPicname(), Field.Store.YES);
			// book description
			Field desc = new TextField("desc", book.getDesc(), Field.Store.YES);
			
			// add field into document
			document.add(bid);
			document.add(title);
			document.add(author);
			document.add(price);
			document.add(points);
			document.add(discount);
			document.add(picname);
			document.add(desc);
			
			// add document into doc list
			docList.add(document);
			
			
		}
		
		Analyzer analyzer = new StandardAnalyzer();
		
		// create IndexWriter
		IndexWriterConfig cfg = new IndexWriterConfig(analyzer);
		
		// path is the lib store your created index
		Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("your_index_path"));
		
		IndexWriter writer = new IndexWriter(directory, cfg);
		writer.deleteAll();
		
		// writer doc into our index lib
		for (Document doc: docList) {
			writer.addDocument(doc);
		}
		
		writer.close();
		
		
		
	}

}
