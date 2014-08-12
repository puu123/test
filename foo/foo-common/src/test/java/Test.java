
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

import jp.co.foo.datamapper.DeptMapper;
import jp.co.foo.datamapper.EmpMapper;
import jp.co.foo.dto.DeptDto;
import jp.co.foo.dto.DeptExample;
import jp.co.foo.dto.EmpDto;
import jp.co.foo.dto.EmpExample;
import jp.co.foo.dto.Zip2Dto;
import jp.co.foo.service.ZipService;

//import jp.co.foo.dto.Zip2Dto;
//import jp.co.foo.service.ZipService;

import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseInt;
import org.supercsv.cellprocessor.Trim;
import org.supercsv.cellprocessor.constraint.StrMinMax;
import org.supercsv.cellprocessor.constraint.Unique;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.io.dozer.CsvDozerBeanReader;
import org.supercsv.prefs.CsvPreference;

import static org.powermock.api.mockito.PowerMockito.*; 

//@RunWith(PowerMockRunner.class)
//@PrepareForTest(String.class)
public class Test {
	
//    @org.junit.Test
//    public void testHashCodeEquivalent() {
//        String foo = "foo";
//        String bar = "bar";
//
//        assertThat(foo.hashCode(), is(not(bar.hashCode())));
//        
//        bar = spy(bar);
//        when(bar.hashCode()).thenReturn(foo.hashCode());
//        
//        assertThat(bar, is("bar"));
//        assertThat(foo.hashCode(), is(bar.hashCode()));
//    }
    
	@org.junit.Test
	public void testLazy() throws Exception {
		ApplicationContext c = new ClassPathXmlApplicationContext("spring/data-access-context.xml");
//		{
//			EmpMapper mapper = c.getBean(EmpMapper.class);
//			int cnt = mapper.countByExample(new EmpExample());
//			System.out.println(cnt);
//		}
		{
			DeptMapper mapper = c.getBean(DeptMapper.class);
			int cnt = mapper.countByExample(new DeptExample());
			System.out.println(cnt);
			DeptDto dept = mapper.selectByPrimaryKey((short)20);
			System.out.println("***"+dept.getDname());
			for(EmpDto emp: dept.getEmps()){
				System.out.println(emp.getEname());
			}
		}
	}
    
//	@org.junit.Test
//	public void testCsvReader1() throws Exception {
//
//		ICsvBeanReader reader = null;		
//		reader = new CsvBeanReader(new FileReader(
//				"./data/foo.csv"), CsvPreference.EXCEL_PREFERENCE);
//		try {
//
//			final String[] header = reader.getHeader(true);
//			
//			ArrayList<String> list = new ArrayList<String>();
//			for (String string : header) {
//				list.add(string.trim());
//			}
//			
//			String[] nameMapping = list.toArray(new String[]{});
//			
//			UserBean user = null;
//			while ((user = reader.read(UserBean.class, nameMapping,
//					UserBean.PROCESSORS)) != null) {
//				
//				System.out.println(reader.getLineNumber());
//				System.out.println(reader.getRowNumber());
//				System.out.println(reader.getUntokenizedRow());
//				
//				// 取得要素をコンソールへ出力
//				System.out.print("ユーザ名:" + user.getUsername());
//				System.out.print(" パスワード:" + user.getPassword());
//				System.out.print(" 日付:" + user.getDate());
//				System.out.print(" 郵便番号:" + user.getZip());
//				System.out.println(" 住所:" + user.getTown());
//			}
//		} finally {
//			reader.close();
//		}
//	}
//
//	@org.junit.Test
//	public void testCsvReader2() throws Exception {
//
//		CsvDozerBeanReader inFile = null;		
//		inFile = new CsvDozerBeanReader(new FileReader(
//				"./data/foo.csv"), CsvPreference.EXCEL_PREFERENCE);
//		try {
//
//			final String[] header = inFile.getHeader(true);
//			inFile.configureBeanMapping(UserBean.class, FIELD_MAPPING);
//			
//			UserBean user = null;
//			while ((user = inFile.read(UserBean.class, UserBean.PROCESSORS)) != null) {
//				// 取得要素をコンソールへ出力
//				System.out.print("ユーザ名:" + user.getUsername());
//				System.out.print(" パスワード:" + user.getPassword());
//				System.out.print(" 日付:" + user.getDate());
//				System.out.print(" 郵便番号:" + user.getZip());
//				System.out.println(" 住所:" + user.getTown());
//			}
//		} finally {
//			inFile.close();
//		}
//	}
//
//	@org.junit.Test
//	public void testCsvReader3() throws Exception {
//		
//		ApplicationContext c = new ClassPathXmlApplicationContext("spring/data-access-context.xml");
//		ZipService service = c.getBean(ZipService.class);
//
//		CsvDozerBeanReader inFile = null;		
//		inFile = new CsvDozerBeanReader(
//				 new BufferedReader(new InputStreamReader(new FileInputStream("./data/KEN_ALL.csv"),"Windows-31j")),				
//				CsvPreference.EXCEL_PREFERENCE);
//		try {
//
//			final String[] header = inFile.getHeader(true);
//			inFile.configureBeanMapping(Zip2Dto.class, FIELD_MAPPING2);
//			service.importFile(inFile);
//			
//		} finally {
//			inFile.close();
//		}
//	}
//	
//	private static final String[] FIELD_MAPPING = new String[] {
//		"username",
//		"password",
//		"date",
//		"zip",
//		"town"
//        };
	private static final String[] FIELD_MAPPING2 = new String[] { "jisCode",
			"postalCodeOld", "postalCode", "prefectureKana", "cityKana",
			"townKana", "prefectureKanji", "cityKanji", "townKanji",
			"townDivideFlag", "koazaBanchiFlag", "tyhoumeFlag",
			"hasSomeTownFlag", "updateStateFlag", "updateReason", };
//
//    public static class UserBean {
//        
//        /** 各要素フォーマット定義 */
//        public static final CellProcessor[] PROCESSORS = new CellProcessor[] {
//                new Unique(new StrMinMax(4, 20)),    // username
//                new StrMinMax(7, 35),                // password
//                new ParseDate("dd/MM/yyyy"),         // date
//                new Optional(new Trim(new ParseInt())),        // zip
//                null                                 // town
//        };
//        
//		/* 各要素の Getter/Setter 定義 */
//
//		private String username; 
//		private String password;
//		private String town;
//		private Date date;
//		private int zip;
//		/**
//		 * @return the username
//		 */
//		public String getUsername() {
//			return username;
//		}
//		/**
//		 * @param username the username to set
//		 */
//		public void setUsername(String username) {
//			this.username = username;
//		}
//		/**
//		 * @return the password
//		 */
//		public String getPassword() {
//			return password;
//		}
//		/**
//		 * @param password the password to set
//		 */
//		public void setPassword(String password) {
//			this.password = password;
//		}
//		/**
//		 * @return the town
//		 */
//		public String getTown() {
//			return town;
//		}
//		/**
//		 * @param town the town to set
//		 */
//		public void setTown(String town) {
//			this.town = town;
//		}
//		/**
//		 * @return the date
//		 */
//		public Date getDate() {
//			return date;
//		}
//		/**
//		 * @param date the date to set
//		 */
//		public void setDate(Date date) {
//			this.date = date;
//		}
//		/**
//		 * @return the zip
//		 */
//		public int getZip() {
//			return zip;
//		}
//		/**
//		 * @param zip the zip to set
//		 */
//		public void setZip(int zip) {
//			this.zip = zip;
//		}
//		
//		
//
//	}
}
