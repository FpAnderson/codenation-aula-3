package challenge;

public class Quote {

	private String actor;

	private String quote;

	public Quote(Builder builder) {
		this.actor = builder.actor;
		this.quote = builder.quote;
	}

	public Quote(){

	}

	public static Builder builder(){
		return new Builder();
	}

	public static final class Builder {
		private String actor;
		private String quote;

		public Builder withactor(String actor) {
			this.actor = actor;
			return this;
		}

		public Builder withquote(String quote) {
			this.quote = quote;
			return this;
		}

		public Quote build() {
			return new Quote(this);
		}
	}

	public String getActor() {
		return actor;
	}

	public String getQuote() {
		return quote;
	}

}
