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
			Field bId = new TextField("bid", Integer.toString(book.getbId()), Field.Store.YES);
			
			// book name
			Field bookName = new TextField("title", book.getBookName(), Field.Store.YES);
			
			// book owner
			Field book_owner = new TextField("title", book.getBook_owner(), Field.Store.YES);
			
			// book class
			Field bookType = new TextField("bookType", book.getBookType(), Field.Store.YES);
			
			// publisher
			Field publisher = new TextField("publisher", book.getPublisher(), Field.Store.YES);
			
			// book author
			Field author = new TextField("author", book.getAuthor(), Field.Store.YES);
			
			// new percent
			Field newDegree = new TextField("newPercent", book.getNewDegree(), Field.Store.YES);
			
			// address
			Field address = new TextField("address", book.getAddress(), Field.Store.YES);
			
			// onsale
			Field onsale = new TextField("onsale", Integer.toString(book.getOnsale()), Field.Store.YES);
			
			// isDel
			Field isDel = new TextField("isDel", Integer.toString(book.getIsDel()), Field.Store.YES);
			
			// book price
			Field price = new TextField("price", Integer.toString(book.getPrice()), Field.Store.YES);

			// book picture name
			Field img = new TextField("img", book.getImg(), Field.Store.YES);
			
			
			// add field into document
			document.add(bId);
			document.add(bookName);
			document.add(book_owner);
			document.add(bookType);
			document.add(publisher);
			document.add(author);
			document.add(newDegree);
			document.add(address);
			document.add(onsale);
			document.add(isDel);
			document.add(price);
			document.add(img);
			
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
