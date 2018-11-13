package newsDemo;

/**
 *  һ���򵥵������¼�������ʾ����
 * @author tds
 * @author �޸��ߣ���������
 * ��Ҫ�Ǽ���һ�����ѵĶ����ߣ����Ҹö�����Ҫ����������ʵ�֡�������Ҫ��ռ8�֣�
 * ������ԣ�Ҳ������Lambda��ʵ�ֵĶ����ߡ����ϸ�Ҫ��ռ2�֣���
 */

public class NewsDemo {
	public static void main(String[] args) {
		
		//ģ����һ��������
		NewsAgency bbc = new NewsAgency("BBC");
		//���ĸ��������
		bbc.addListener(new MyListener());
		
		//TODO ���������ټ���һ��Listener
		//������
		bbc.addListener(new Listener(){
		@Override
		public void newsArrived(NewsEvent e){
			if(e.level>5){
				System.out.println("waring: ");
			}System.out.println("Please note, "+e.text+" happened!");
		}
	});
		//lambda
		bbc.addListener(e -> {
				if (e.level > 5)
					System.out.println("warning :");
				System.out.println("please note," + e.text + " happed!");
	});
		//�����������乤������
		bbc.start();				
	}
}


/**
 * �¼���Ϣ
 */
class NewsEvent{
	Object source;  //�¼���Դ
	String text;    //�¼�����
	int level;      //�¼�����
	NewsEvent(Object source, String text, int level){
		this.source=source;
		this.text = text;
		this.level = level;		
	}
}
interface Listener{
	void newsArrived(NewsEvent e);
}

/**
 * ���Ż���
 */
class NewsAgency {
	String name; //������
	public NewsAgency(String name) {
		this.name = name;		
	}
	Listener[] listeners = new  Listener[100]; //�����ߣ������ߣ�
	int listenerCnt = 0; //���еĶ�����
	
	//����һ��������
	void addListener(Listener oneListener){
		if(listenerCnt<listeners.length){
			listeners[listenerCnt] = oneListener;
			listenerCnt++;
		}		
	}
	
	//ģ��һ���¼���������֪ͨ���еĶ�����
	void start(){
		NewsEvent event = new NewsEvent("Mr. Joan", "Bombing", 9 );
		
		for(int i=0; i<listenerCnt; i++) {
			listeners[i].newsArrived(event);
		}
		
	}
}

/**
 * ʵ��һ��������
 */
class MyListener implements Listener{
	//�����յ���Ϣ�󣬽���һЩ��ʾ
	public void newsArrived(NewsEvent e){
		if( e.level>5) System.out.println("warning :");
		System.out.println("please note," + e.text + " happed!");
	}
}
