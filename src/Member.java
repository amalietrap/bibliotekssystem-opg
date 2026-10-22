public class Member {
    private final String name;
    private final int memberNumber;

    public Member(String name, int memberNumber) {
        this.name = name;
        this.memberNumber = memberNumber;
    }

    public int getMemberId() {
        return memberNumber;
    }

    public String toString() {
        return name + " (Lånernummer: " + memberNumber + ")";
    }
}
