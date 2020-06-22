package com.bridgelabz.bookstore.service;

import com.bridgelabz.bookstore.dto.CartDto;
import com.bridgelabz.bookstore.model.NewUserData;
import com.bridgelabz.bookstore.repository.IBookRepository;
import com.bridgelabz.bookstore.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class MailServiceImpl implements IMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IUserRepository userRepository;

    /**
     * @param newUserData - User data to send mail on successful user registration
     * @throws MessagingException
     */
    @Override
    public void sendRegisterMail(NewUserData newUserData) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Thank you for registering");
        helper.setTo(newUserData.getEmail());
        helper.setText("Dear " + newUserData.getName() + ",\n" +
                "\n" +
                "Thank you for your registration. If you have any questions, please let me know!.\n" +
                "\n" +
                "Thank you , Have great day,", false);
        javaMailSender.send(message);

    }

    /**
     * @param newUserData - User data to send reset password link via mail
     * @param jwt         - JWT token for authentication
     * @throws MessagingException
     */
    @Override
    public void sendForgetPasswordMail(NewUserData newUserData, String jwt) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Reset Password Link");
        helper.setTo(newUserData.getEmail());
        helper.setText("Dear " + newUserData.getName() + ",\n" +
                "Click on the below link to reset Your password.\n" +
                "http://localhost:3000/reset-password/" + jwt + "\n" +
                "Regards ,\n" +
                "The Bookstore Team", false);
        javaMailSender.send(message);
    }

    /**
     * @param cartDtos - Ordered book details
     * @param userId   - UserId to send mail with ordered book details on successful order
     * @throws MessagingException
     */
    @Override
    public void sendOrderDetailMail(List<CartDto> cartDtos, Long userId) throws MessagingException {
        double sum = 0;
        StringBuilder email = new StringBuilder();
        email.append("<table style='border:2px solid black'>");
        email.append("<tr bgcolor=\"#33CC99\"><th>Book Title</th><th>Book Quantity</th><th>Price</th></tr>");
        for (CartDto cartDto : cartDtos) {
            email.append("<tr bgcolor=\"#33CC99\">");

            email.append("<td>");
            email.append(bookRepository.findById(cartDto.getBookId()).get().getBookTitle());
            email.append("</td>");

            email.append("<td>");
            email.append(cartDto.getQuantity());
            email.append("</td>");

            email.append("<td>");
            email.append((bookRepository.findById(cartDto.getBookId()).get().getBookPrice() * cartDto.getQuantity()));
            email.append("</td>");

            email.append("</tr>");

            sum += bookRepository.findById(cartDto.getBookId()).get().getBookPrice() * cartDto.getQuantity();
        }
        email.append("<tr bgcolor=\"#33CC99\"><td colspan=\"2\"><b>" + "Total   Amount" + "</b></td><td><b>" + sum
                + "</b></td></tr>");
        email.append("</table>");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setSubject("Order Confirm");
        helper.setFrom("TheBookstore@gmail.com");
        helper.setTo(userRepository.findById(userId).get().getEmail());
        helper.setText("<html><body><h3 style='color:darkOrange'>" + "Hello " + userRepository.findById(userId)
                .get().getFirstName() + " " + userRepository.findById(userId)
                .get().getLastName() + ",</h3>" +
                "<h4 style='color:green'>Your Order has been placed successfully!.</h4>" + "Your order Id is #12345.<br></br><br></br>" +
                "Order Details : " + "<br></br>" +
                email.toString() + "<br></br>" +
                "Regards" + "," + "<br></br>" +
                "The Bookstore Team" +
                "</body></html>", true);
        javaMailSender.send(message);
    }
}
