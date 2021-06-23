package controllers;


import javax.inject.Inject;

import models.Diploma;
import repositories.DiplomaRepository;
import play.mvc.*;
import java.time.LocalDate;

//upload files
import play.libs.Files.TemporaryFile;
import java.nio.file.Paths;
import play.data.Form;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class DiplomaController extends Controller{
	@Inject
    private DiplomaRepository diploma;

    public Result readDiploma(String id) {
        Diploma d = diploma.findById(id);
        LocalDate issueDate = d.getIssueDate();
        String diplomaType = d.getTypeOfDiploma();
        return ok(views.html.readDiploma.render(issueDate.toString(), diplomaType));

    }
    
    
    public Result writeDiploma() {
    	LocalDate issueDate = LocalDate.parse("2020-01-08");
    	LocalDate expirationDate = LocalDate.parse("2100-01-08");
    	String diplomaType = "bachelor degree";
    	Diploma d = new Diploma(issueDate, expirationDate, diplomaType);
    	diploma.save(d);
        return ok("A new diploma was insert in database.");

    }
    
    
    /*
     * upload files
     */
    
    private final play.data.FormFactory formFactory;
    private MessagesApi messagesApi;

    @Inject
    public DiplomaController(play.data.FormFactory formFactory, MessagesApi messagesApi) {
        this.formFactory = formFactory;
        this.messagesApi = messagesApi;
    }

    public Result index(Http.Request request ) {
        Form<FormData> form = formFactory.form(FormData.class).bindFromRequest(request);
        Messages messages = this.messagesApi.preferred(request);
        return ok(views.html.uploadDiploma.render(form, request, messages));
    }

    /**
     * This method uses MyMultipartFormDataBodyParser as the body parser
     */
    @BodyParser.Of(MyMultipartFormDataBodyParser.class)
    public Result upload(Http.Request request) throws IOException {
        final Http.MultipartFormData<File> formData = request.body().asMultipartFormData();
        final Http.MultipartFormData.FilePart<File> filePart = formData.getFile("File upload");
        final File file = filePart.getRef();
        final long data = operateOnTempFile(file);
        
        /*
         * 
         */
        InputStream targetStream = new FileInputStream(file);
        String md5 = org.apache.commons.codec.digest.DigestUtils.md5Hex(targetStream);
        
        LocalDate issueDate = LocalDate.parse("2020-01-08");
    	LocalDate expirationDate = LocalDate.parse("2100-01-08");
    	String diplomaType = "master degree";
    	
    	Diploma d = new Diploma(issueDate, expirationDate, diplomaType, md5);
    	diploma.save(d);
        
        return ok("file size = " + data + "");
    }

    private long operateOnTempFile(File file) throws IOException {
        final long size = Files.size(file.toPath());
      //  Files.deleteIfExists(file.toPath());
        return size;
    }
}
