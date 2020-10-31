package EmployeePayrollService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

import org.junit.Assert;
import org.junit.Test;

public class NIOFileAPITest {

	private static final String HOME = System.getProperty("user.home");
	private static String PLAY_WITH_NIO = "TempPlayGround";

	/**
	 * checks for existing file and returns true
	 */
	@Test
	public void givenPathToCheckForHomeDirectory_WhenAnalyse_ShouldReturnTrue() {

		Path homePath = Paths.get(HOME);
		Assert.assertTrue(Files.exists(homePath));

	}

	/**
	 * checks for non existing file and should return true
	 */
	@Test
	public void deleteFileAndCheckForItsExistence_WhenAanalyse_ShouldReturnTrue() throws IOException {

		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		if (Files.exists(playPath))
			Files.delete(playPath);
		Assert.assertTrue(Files.notExists(playPath));

	}

	/**
	 * creates a directory and check for its existence and returns true
	 */
	@Test
	public void createdDirectoryAndCheckForItsExistence_WhenAnalyse_ShouldReturnTrue() throws IOException {

		Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
		Files.createDirectory(playPath);
		Assert.assertTrue(Files.exists(playPath));
	}

	@Test
	public void checkForNonExistingFileAndCreating_WhenAnalyse_ShouldReturnTrue() {

		Path playPath = Paths.get(PLAY_WITH_NIO);
		IntStream.range(1, 10).forEach(cntr -> {
			Path tempFile = Paths.get(playPath + "/temp" + cntr);
			Assert.assertTrue(Files.exists(playPath));
			try {
				Files.createFile(tempFile);
			} catch (IOException e) {
			}
		});
	}

	public void listFilesAndDirectories() throws IOException {

		Path playPath = Paths.get(PLAY_WITH_NIO);
		Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
		Files.newDirectoryStream(playPath).forEach(System.out::println);
		Files.newDirectoryStream(playPath, path -> path.toFile().isFile() && path.toString().startsWith("temp"))
				.forEach(System.out::println);
	}

}
