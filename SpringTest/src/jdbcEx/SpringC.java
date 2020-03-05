package jdbcEx;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringC 
{
	public static void main(String[] args) 
	{
		Presentation x = null;
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("note.xml");
		x = cpx.getBean(Presentation.class);
		//x.singleSelect();
		//x.multiSelector();
		x.deleteCust();
		//x.InsertCust();
		//x.UpdateSelected();
	}
	
}
