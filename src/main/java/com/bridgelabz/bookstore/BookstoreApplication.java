package com.bridgelabz.bookstore;

import com.bridgelabz.bookstore.model.Book;
import com.bridgelabz.bookstore.repository.IBookRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    ApplicationRunner applicationRunner(IBookRepository bookRepository) {
        return args -> {
            if (!bookRepository.findAll().iterator().hasNext()) {
                bookRepository.save(new Book("Chetan Bhagat", "Girl In Room 105 1", "https://elearningindustry.com/wp-content/uploads/2016/05/top-10-books-every-college-student-read-e1464023124869.jpeg", 4, 230, "new book"));
                bookRepository.save(new Book("Chetan Bhagat", "The Girl in Room 105", "http://books.google.com/books/content?id=GHt_uwEACAAJ&printsec=frontcover&img=1&zoom=5", 12, 193.0, "Hi I'm Keshava"));
                bookRepository.save(new Book("Rujuta Divekar", "Indian Superfoods", "http://books.google.com/books/content?id=4oFoDwAAQBAJ&printsec=frontcover&img=1&zoom=5", 13, 495.0, "Forget about aca"));
                bookRepository.save(new Book("Dan Brown", "Angels And Demons", "http://books.google.com/books/content?id=d5xgYw4Ts0gC&printsec=frontcover&img=1&zoom=5", 14, 218.0, "*INCLUDES A SNEAK PRE"));
                bookRepository.save(new Book("Dan Brown", "Angels & Demons - Movie Tie-In", "http://books.google.com/books/content?id=GXznEnKwTdAC&printsec=frontcover&img=1&zoom=5", 15, 462.0, "The murd"));
                bookRepository.save(new Book("Dan Brown", "Origin", "http://books.google.com/books/content?id=95wnDQAAQBAJ&printsec=frontcover&img=1&zoom=5", 16, 174.0, "Sunday Times #1 Bestseller New Y"));
                bookRepository.save(new Book("Dan Brown", "Deception Point", "http://books.google.com/books/content?id=tYwq0H5HcrcC&printsec=frontcover&img=1&zoom=5", 12, 128.0, "*INCLUDES A SNEAK PREVI"));
                bookRepository.save(new Book("Dan Brown", "Digital Fortress", "http://books.google.com/books/content?id=pfB9VsrdX4IC&printsec=frontcover&img=1&zoom=5", 14, 573.0, "*INCLUDES A SNEAK PREV"));
                bookRepository.save(new Book("Dan Brown", "Inferno", "http://books.google.com/books/content?id=9nloexmq6QsC&printsec=frontcover&img=1&zoom=5", 12, 951.0, "#1 WORLDWIDE BESTSELLER Harvard"));
                bookRepository.save(new Book("Dan Brown", "The Da Vinci Code", "http://books.google.com/books/content?id=ivzfRJGrdFsC&printsec=frontcover&img=1&zoom=5", 13, 348.0, "*INCLUDES AN EXTRACT "));
                bookRepository.save(new Book("Dan Brown", "Robert Langdon Omnibus", "http://books.google.com/books/content?id=IqPW7mqq6GIC&printsec=frontcover&img=1&zoom=5", 14, 451.0, "Thriller. Two bo"));
                bookRepository.save(new Book("Dan Brown", "Angels And Demons", "http://books.google.com/books/content?id=d5xgYw4Ts0gC&printsec=frontcover&img=1&zoom=5", 15, 612.0, "*INCLUDES A SNEAK PRE"));
                bookRepository.save(new Book("Dan Brown", "Origin – Read a Free Sample Now", "http://books.google.com/books/content?id=Wj81DwAAQBAJ&printsec=frontcover&img=1&zoom=5", 16, 530.0, "An extr"));
                bookRepository.save(new Book("Dan Brown", "Inferno - Illustrated Edition", "http://books.google.com/books/content?id=IPsKBAAAQBAJ&printsec=frontcover&img=1&zoom=5", 12, 415.0, "SEEK AND "));
                bookRepository.save(new Book("Stephen King", "Carrie", "http://books.google.com/books/content?id=KOPSjMuVN4kC&printsec=frontcover&img=1&zoom=5", 14, 444.0, "Stephen Kings legendary debut"));
                bookRepository.save(new Book("Stephen King", "On Writing", "http://books.google.com/books/content?id=d999Z2KbZJYC&printsec=frontcover&img=1&zoom=5", 12, 233.0, "The author shares his ins"));
                bookRepository.save(new Book("Stephen King", "Night Shift", "http://books.google.com/books/content?id=YTDDiSUsD-EC&printsec=frontcover&img=1&zoom=5", 13, 441.0, "More than twenty-five st"));
                bookRepository.save(new Book("Stephen King", "The Stephen King companion", "http://books.google.com/books/content?id=27ghAQAAIAAJ&printsec=frontcover&img=1&zoom=5", 14, 1034.0, "Contains"));
                bookRepository.save(new Book("Stephen King", "Just After Sunset", "http://books.google.com/books/content?id=3833y1SEHG4C&printsec=frontcover&img=1&zoom=5", 15, 1024.0, "This collection o"));
                bookRepository.save(new Book("Stephen King", "The Stand", "http://books.google.com/books/content?id=UbfnTcmkaKkC&printsec=frontcover&img=1&zoom=5", 16, 995.0, "Stephen King’s apocalyptic"));
                bookRepository.save(new Book("Stephen King", "Danse Macabre", "http://books.google.com/books/content?id=Rs1WbPRa3LoC&printsec=frontcover&img=1&zoom=5", 12, 563.0, "From the author of doz"));
                bookRepository.save(new Book("Stephen King", "It", "http://books.google.com/books/content?id=KiszDwAAQBAJ&printsec=frontcover&img=1&zoom=5", 14, 967.0, "It began -- and ended -- in 1958 "));
                bookRepository.save(new Book("Stephen King", "Cell", "http://books.google.com/books/content?id=y0L2B1E8w74C&printsec=frontcover&img=1&zoom=5", 12, 238.0, "From international bestseller S"));
                bookRepository.save(new Book("Stephen King", "Salems Lot", "http://books.google.com/books/content?id=7_4NgDQhtDYC&printsec=frontcover&img=1&zoom=5", 13, 465.0, "‘Turn off the television "));
                bookRepository.save(new Book("Stephen King", "Pet Sematary", "http://books.google.com/books/content?id=FNn5DQAAQBAJ&printsec=frontcover&img=1&zoom=5", 14, 645.0, "Newly introduced by the"));
                bookRepository.save(new Book("Stephen King", "Christine", "http://books.google.com/books/content?id=DdHRpPUi5LsC&printsec=frontcover&img=1&zoom=5", 15, 1078.0, "A scarlet-and-white1958 P"));
                bookRepository.save(new Book("Stephen King", "11/22/63", "http://books.google.com/books/content?id=xcBR6LCcsd4C&printsec=frontcover&img=1&zoom=5", 16, 511.0, "ON NOVEMBER 221963THREE SHO"));
                bookRepository.save(new Book("Stephen King", "Different Seasons", "http://books.google.com/books/content?id=XSIUoqwXhH0C&printsec=frontcover&img=1&zoom=5", 12, 984.0, "Read the original "));
                bookRepository.save(new Book("Stephen King", "Bag of Bones", "http://books.google.com/books/content?id=kDZSh9rtva4C&printsec=frontcover&img=1&zoom=5", 14, 1079.0, "Set in the fictional t"));
                bookRepository.save(new Book("Stephen King", "The Shining", "http://books.google.com/books/content?id=zVq8BF_5vSUC&printsec=frontcover&img=1&zoom=5", 12, 780.0, "One of the true classics"));
                bookRepository.save(new Book("Stephen King", "Everythings Eventual", "http://books.google.com/books/content?id=XCMu2NrzCpwC&printsec=frontcover&img=1&zoom=5", 13, 975.0, "A collection of"));
                bookRepository.save(new Book("Stephen King", "The Green Mile", "http://books.google.com/books/content?id=KNA7gfXJw9sC&printsec=frontcover&img=1&zoom=5", 14, 552.0, "Stephen Kings interna"));
                bookRepository.save(new Book("Stephen King", "Insomnia", "http://books.google.com/books/content?id=lhUmmcwQEgMC&printsec=frontcover&img=1&zoom=5", 15, 925.0, "Ralph Robertsa widower suff"));
                bookRepository.save(new Book("Stephen King", "The Talisman", "http://books.google.com/books/content?id=oZie_Bx1B1MC&printsec=frontcover&img=1&zoom=5", 16, 1100.0, "Twelve-year-old Jack S"));
                bookRepository.save(new Book("Stephen King", "Stephen King Goes to the Movies", "http://books.google.com/books/content?id=Qbm5ejIoY5sC&printsec=frontcover&img=1&zoom=5", 12, 1048.0, "A c"));
                bookRepository.save(new Book("Stephen King", "The Mist", "http://books.google.com/books/content?id=41LdDgAAQBAJ&printsec=frontcover&img=1&zoom=5", 14, 117.0, "#1 New York Times bestselli"));
                bookRepository.save(new Book("Stephen King", "The Essential Stephen King", "http://books.google.com/books/content?id=OeL8swEACAAJ&printsec=frontcover&img=1&zoom=5", 12, 917.0, "In this n"));
                bookRepository.save(new Book("Stephen King", "Liseys Story", "http://books.google.com/books/content?id=u5aJe6Mb0YIC&printsec=frontcover&img=1&zoom=5", 13, 280.0, "Two years after losing "));
                bookRepository.save(new Book("Stephen King", "American Vampire", "http://books.google.com/books/content?id=FwlDtQEACAAJ&printsec=frontcover&img=1&zoom=5", 14, 336.0, "Features a new bree"));
                bookRepository.save(new Book("Stephen King", "Misery", "http://books.google.com/books/content?id=t-ArDgAAQBAJ&printsec=frontcover&img=1&zoom=5", 15, 777.0, "Originally published: New Yor"));
                bookRepository.save(new Book("Stephen King", "Needful Things", "http://books.google.com/books/content?id=LlXKLAjHAeYC&printsec=frontcover&img=1&zoom=5", 16, 384.0, "Set in the fictional "));
                bookRepository.save(new Book("Stephen King", "The Running Man", "http://books.google.com/books/content?id=XvuoCwAAQBAJ&printsec=frontcover&img=1&zoom=5", 12, 966.0, "With an Introduction"));
                bookRepository.save(new Book("Stephen King", "Firestarter", "http://books.google.com/books/content?id=VyWagxzwDrQC&printsec=frontcover&img=1&zoom=5", 14, 1032.0, "Stephen King’s “gem of "));
                bookRepository.save(new Book("Stephen King", "Bare Bones", "http://books.google.com/books/content?id=9GJAPgAACAAJ&printsec=frontcover&img=1&zoom=5", 12, 934.0, "In a series of interviews"));
                bookRepository.save(new Book("Stephen King", "The Long Walk", "http://books.google.com/books/content?id=RlkzWP9JvE8C&printsec=frontcover&img=1&zoom=5", 13, 725.0, "In this #1 national be"));
                bookRepository.save(new Book("Stephen King", "Dyneins", "http://books.google.com/books/content?id=PcBvQC_O870C&printsec=frontcover&img=1&zoom=5", 14, 128.0, "With an accompanying Web sit"));
                bookRepository.save(new Book("Stephen King", "Sleeping Beauties", "http://books.google.com/books/content?id=G4Q2DwAAQBAJ&printsec=frontcover&img=1&zoom=5", 15, 444.0, "The authors tell t"));
                bookRepository.save(new Book("Stephen King", "Under the Dome", "http://books.google.com/books/content?id=GR1m1MZwTjoC&printsec=frontcover&img=1&zoom=5", 16, 311.0, "The second season of "));
                bookRepository.save(new Book("Stephen King", "The Dark Half", "http://books.google.com/books/content?id=G7OxASGZpUMC&printsec=frontcover&img=1&zoom=5", 12, 1089.0, "Set in the fictional "));
                bookRepository.save(new Book("Stephen King", "Dolores Claiborne", "http://books.google.com/books/content?id=dUQat2unQE8C&printsec=frontcover&img=1&zoom=5", 14, 833.0, "Dolores Claiborne "));
                bookRepository.save(new Book("Stephen King", "The Second Stephen King Quiz Book", "http://books.google.com/books/content?id=aUirWV4S8psC&printsec=frontcover&img=1&zoom=5", 12, 237.0, "A "));
                bookRepository.save(new Book("Stephen King", "The Dark Tower VII", "http://books.google.com/books/content?id=Geq0uKAxZPEC&printsec=frontcover&img=1&zoom=5", 13, 639.0, "The final install"));
                bookRepository.save(new Book("Stephen King", "Doctor Sleep", "http://books.google.com/books/content?id=DQTgAAAAQBAJ&printsec=frontcover&img=1&zoom=5", 14, 245.0, "After decades as an iti"));
            }
        };
    }
}
