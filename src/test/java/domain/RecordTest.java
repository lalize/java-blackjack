package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RecordTest {
	@Test
	void create() {
		assertThat(new Record(0, 0)).isInstanceOf(Record.class);
	}

	@Test
	void create_카운트가_0_미만인_경우() {
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Record(-1, 0));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Record(0, -1));
		assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new Record(-1, -1));
	}
}
