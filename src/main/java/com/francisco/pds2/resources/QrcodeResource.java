package com.francisco.pds2.resources;
import java.io.IOException;

//import javax.xml.ws.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.services.UsuarioService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value = "/qrcode")
@CrossOrigin
public class QrcodeResource {

	@Autowired
	private UsuarioService service;
	

	

	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> geraImagemQrcode(@PathVariable Integer codUsuario)
			throws WriterException, IOException {

		Usuario obj = service.find(codUsuario);
		String baseQrcode = Integer.toString(obj.getInscricoes().iterator().next().getBaseQrcode());
		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl(CacheControl.noCache().getHeaderValue());
		headers.setContentType(MediaType.IMAGE_PNG);

		// try {
		byte[] qrCode = obj.getQrcode(baseQrcode, 350, 350);
		ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(qrCode, headers, HttpStatus.OK);

		// } catch (WriterException e) {
		// System.out.println("Could not generate QR Code, WriterException :: " +
		// e.getMessage());
		// } catch (IOException e) {
		// System.out.println("Could not generate QR Code, IOException :: " +
		// e.getMessage());
		// }
		return responseEntity;

	}
}