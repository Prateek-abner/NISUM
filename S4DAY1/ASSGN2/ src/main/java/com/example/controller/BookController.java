@RestController
@RequestMapping("/api/books")
public class BookController {
    @PostMapping
    public ResponseEntity<Book> create(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(book);
    }
}
