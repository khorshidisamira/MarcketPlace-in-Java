package onlineMarket;

import java.rmi.Remote;
import java.rmi.RemoteException; 

/**
 *
 * @author Samira
 */
public interface CategoryInterface extends Remote
{
    public int add(CategoryModel category) throws RemoteException;
    public CategoryModel[] list() throws RemoteException;
    public void update(CategoryModel category) throws RemoteException;
    public void remove(int categoryId) throws RemoteException;
    public CategoryModel detail(int categoryId) throws RemoteException; 
}