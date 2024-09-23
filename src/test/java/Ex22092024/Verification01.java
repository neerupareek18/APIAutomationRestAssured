package Ex22092024;

import org.testng.annotations.Test;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static org.assertj.core.api.Assertions.*;

public class Verification01 {
    @Test
    public void verify_Date(){
        LocalDate date = LocalDate.now();
        System.out.println(date);

        LocalDateTime datetime = LocalDateTime.now();
        System.out.println(datetime);

        assertThat(date).hasDayOfMonth(23);
        assertThat(date).isAfterOrEqualTo(LocalDate.of(2024,8,20));
        assertThat(date).isBeforeOrEqualTo(LocalDate.of(2025,8,20));
        assertThat(date).isBetween(LocalDate.of(2024,8,20),LocalDate.of(2025,7,31));

    }

    @Test
    public void verify_File(){
        File f = new File("TestingData");
        assertThat(f).doesNotExist();
        assertThat(f).canWrite().canRead();
    }


}
