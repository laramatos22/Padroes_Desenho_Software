package ex2;

public interface ContactsInterface {
    public void openAndLoad(ContactsStorageInterface storage);
    public void saveAndClose();
    public void saveAndClose(ContactsStorageInterface storage);
    public boolean exist(Contact contact);
    public Contact getByName(String name);
    public boolean add(Contact contact);
    public boolean remove(Contact contact);
}
