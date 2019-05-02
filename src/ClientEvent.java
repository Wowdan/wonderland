/*

*/

public class ClientEvent{

	private Client client;
	
	public ClientEvent(Client client){
		this.client = client;	
	}
	public String getName(){
		return client.name;
	}
	public String getIp(){
		return client.ip;
	}

}



public interface ClientListener{
	
	void clientAdded(ClientEvent event);
	void clientRemove(ClientEvent event);
}


import java.util.ArrayList;

public class ClientQueue{
	
	private ArrayList clients = new ArrayList();
	private ArrayList listeners = new ArrayList();
	public void addClientListener(ClientListener listener){
		listeners.add(listener);
	}
	
	public void add(Client client){
		clients.add(client);
		ClientEvent event = new ClientEvent(event);
		for(int i = 0; i<listeners.size(); i++){
			ClientListener listener = (ClientListener) listeners.get(i);
			listener.clientAdded(event);
			}
	}	
	public void add(Client client){
		clients.remove(client);
		ClientEvent event = new ClientEvent(event);
		for(int i = 0; i<listeners.size(); i++){
			ClientListener listener = (ClientListener) listeners.get(i);
			listener.clientRemoved(event);
			}		
    }

}


public class MultiChat{
	
	public static void main(String[] args){
		
		Client c1 = new Client("127.0.0.1","Peter");
		Client c2 = new Client("192.168.0.2","John");
		
		ClientQueue queue = new ClientQueue();
		
		queue.addClientListener(new ClientListener(){
			
			@Override
			public void clientAdded(ClientEvent event){
				System.out.printf("%s 從 %s 連線 %n", event.getName(), event.getIp());
			}
			
			@Override
			public void clientRemoved(ClientEvent event){
				System.out.printf("%s 從 %s 連線 %n", event.getName(), event.getIp());
			}
		});
		
		queue.add(c1);
		queue.add(c2);
		
		queue.remove(c1);
		queue.remove(c2);
		
	}
}

/*int[] arrs = {10,20};
Object o = new Object(){
	
	public String toString(){
		
		return "example" + arrs[0];
		}
};*/