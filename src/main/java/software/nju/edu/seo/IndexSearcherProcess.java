package software.nju.edu.seo;

import java.io.IOException;
import java.nio.file.FileSystems;

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

public class IndexSearcherProcess {
	
	
	private int query_result_max_count = 10;
	
	private void startSearchProcess(Query query) {
		try {
			// create Directory
			Directory directory = FSDirectory.open(FileSystems.getDefault().getPath("your_index_path"));
			IndexReader reader = DirectoryReader.open(directory);
			IndexSearcher searcher = new IndexSearcher(reader);
			// 
			TopDocs topDocs = searcher.search(query, query_result_max_count);
			
			int hitCounts = topDocs.totalHits;
			System.out.println("hit records counts = " + hitCounts);
			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
			
			for (ScoreDoc scoreDoc : scoreDocs) {
				int docId = scoreDoc.doc;
				
				Document doc = searcher.doc(docId);
				
				System.out.println("book id :" + doc.get("bid"));
				System.out.println("book title :" + doc.get("title"));
				
				
				
			}
			
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void indexSearch() throws Exception {
		Analyzer analyzer = new StandardAnalyzer();
		
		QueryParser parser = new QueryParser("title", analyzer);
		
		
		// lucene query
		Query query = parser.parse("title:key1 AND key2");
		
		startSearchProcess(query);
		
		
		
	}

}
