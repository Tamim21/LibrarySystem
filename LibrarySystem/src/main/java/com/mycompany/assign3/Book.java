package com.mycompany.assign3;
class Book extends User
{
    private String authorName;
    private String publisherName;
    private int quantity;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName()
    {
        return publisherName;
    }

    public void setPublisherName(String publisherName)
    {
        this.publisherName = publisherName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 0)
            this.quantity= 0;
        else
            this.quantity = quantity;
    }

    public Book(String id, String title, String authorName, String publisherName, int quantity)
    {

        this.setID(id);
        this.setName(title);
        this.setAuthorName(authorName);
        this.setPublisherName(publisherName);
        this.setQuantity(quantity);
    }
    public String lineRepresentation()
    {
        String data;
        data = this.getID() + "," + this.getName() + "," + this.getAuthorName() + "," + this.getPublisherName()+","+this.getQuantity();
        return data;
    }
    public String getSearchKey()
    {
        return this.getID();
    }
}
    