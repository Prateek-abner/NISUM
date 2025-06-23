@WebMvcTest(BookController.class)
public class BookControllerTest {
    @Autowired MockMvc mockMvc;

    @Test
    public void testCreate() throws Exception {
        mockMvc.perform(post("/api/books")
            .content("{\"title\":\"Test\", \"pages\":100}")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }
}
