package software.nju.edu.util;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import software.nju.edu.domain.entity.Book;

public class IndexSearcherUtil {
	
	
	private int query_result_max_count = 10;
	
	private List<Book> startSearchProcess(Query query) {
		try {
			// create Directory
			String luceneIndexPath;
			luceneIndexPath = new LuceneUtil().getLuceneIndex();
			
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath(luceneIndexPath));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			// 
			TopDocs topDocs = searcher.search(query, query_result_max_count);
			
			int hitCounts = topDocs.totalHits;
			System.out.println("hit records counts = " + hitCounts);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			
			if (hitCounts <= 0)
				return null;
			
			List<Book> queryResultBookList = new ArrayList<Book>();
			
			for (ScoreDoc scoreDoc : scoreDocs) {
				int docId = scoreDoc.doc;
				
				Document doc = searcher.doc(docId);
				
				Book resultBook = new Book();
				System.out.println("book id :" + doc.get("bId"));
				System.out.println("book name :" + doc.get("bookName"));
				
				// set attribute for result book.
				try {
					resultBook.setbId(Integer.valueOf(doc.get("bId")));
					resultBook.setBookName(doc.get("bookName"));
					resultBook.setBook_owner(doc.get("book_owner"));	
					resultBook.setBookType(doc.get("bookType"));
					resultBook.setPublisher(doc.get("publisher"));
					resultBook.setAuthor(doc.get("author"));
					resultBook.setNewDegree(doc.get("newDegree"));
					resultBook.setAddress(doc.get("address"));
					resultBook.setOnsale(doc.get("onsale")==null?0:Integer.valueOf(doc.get("onsale")));
					resultBook.setIsDel((doc.get("isdel")==null)?0:Integer.valueOf(doc.get("isDel")));
					resultBook.setPrice(doc.get("price")==null?0:Integer.valueOf(doc.get("price")));
					resultBook.setImg(doc.get("img"));
					
					// add result book into result book list
					queryResultBookList.add(resultBook);
					
				} catch (Exception e) {
					
				}
				
				
				
			}
			
			reader.close();
			
			return queryResultBookList;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<Book> indexSearch(String key) throws Exception {
		Analyzer analyzer = new StandardAnalyzer();
		
		QueryParser parser = new QueryParser("bookName", analyzer);
		
		// lucene query, extend new parse method.
		Query query = parser.parse(key);
		
		List<Book> queryResultBookList = startSearchProcess(query);
		
		return queryResultBookList;
		
		
	}

}
