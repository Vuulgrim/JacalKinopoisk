package controllerTest;
import com.example.JacalKinopoisk.Controllers.SiteController;
import com.example.JacalKinopoisk.models.film;
import com.example.JacalKinopoisk.services.filmService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(SiteController.class)
class controllerTest {
    private static long id;
    private static int page;
    private static int limit;
    private static film mockMovie;
    private static List<film> mockMovieList;
    private static String movieName;
    private static String mockMovieAsJsonString;
    private static String mockMovieListAsJsonString;

    private static String rating;
    private static String genre;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private filmService movieService;

    @SneakyThrows
    @BeforeEach
    void setUp() {
        page = 1;
        limit = 1;
        id = 1L;
        movieName = "Форсаж";
        rating = "7";
        genre = "триллер";

        mockMovie = new film();
        mockMovie.setId(id);
        mockMovie.setName(movieName);
        mockMovieAsJsonString = objectMapper.writeValueAsString(mockMovie);

        mockMovieList = new ArrayList<>(List.of(mockMovie));
        mockMovieListAsJsonString = objectMapper.writeValueAsString(mockMovieList);
    }

    @Test
    void getById() throws Exception {
        when(movieService.getById(anyLong())).thenReturn(mockMovie);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/" + id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockMovieAsJsonString))
                .andExpect(status().isOk());

        verify(movieService).getById(id);
    }

    @Test
    void getByPageByName() throws Exception {
        when(movieService.getByPageByName(anyInt(), anyInt(), anyString())).thenReturn(mockMovieList);

        mockMvc.perform(MockMvcRequestBuilders.get("/movies/search")
                        .param("name", String.valueOf(movieName))
                        .param("page", String.valueOf(page))
                        .param("limit", String.valueOf(limit))
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mockMovieListAsJsonString))
                .andExpect(status().isOk());

        verify(movieService).getByPageByName(page, limit, movieName);
    }