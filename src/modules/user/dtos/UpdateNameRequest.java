package modules.user.dtos;

public final class UpdateNameRequest {
    private final String name;

    public UpdateNameRequest(String name) {
        this.name = name;
    }

    public String getName() { return name; }
}
