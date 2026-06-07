public abstract class CardHolder extends Reader {
    public CardHolder(String id, String name, String email) {
        super(id, name, email);
    }

    public abstract void renewCard(int months);
}
