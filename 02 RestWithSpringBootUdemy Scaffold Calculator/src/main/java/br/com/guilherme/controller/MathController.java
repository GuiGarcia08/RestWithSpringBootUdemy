package br.com.guilherme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.guilherme.exception.UnsuportedMathOperationException;
import br.com.guilherme.math.SimpleMath;
import br.com.guilherme.request.converters.NumberConverter;

@RestController
public class MathController {

	@Autowired
	private NumberConverter numberconverter;
	@Autowired
	private SimpleMath math;

	@RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!numberconverter.isNumeric(numberOne) || !numberconverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.sum(numberconverter.convertToDouble(numberOne), numberconverter.convertToDouble(numberTwo));

	}

	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!numberconverter.isNumeric(numberOne) || !numberconverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.sub(numberconverter.convertToDouble(numberOne), numberconverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!numberconverter.isNumeric(numberOne) || !numberconverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.div(numberconverter.convertToDouble(numberOne), numberconverter.convertToDouble(numberTwo));

	}

	@RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!numberconverter.isNumeric(numberOne) || !numberconverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.mul(numberconverter.convertToDouble(numberOne), numberconverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/mean/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double mean(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo)
			throws Exception {
		if (!numberconverter.isNumeric(numberOne) || !numberconverter.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.mean(numberconverter.convertToDouble(numberOne), numberconverter.convertToDouble(numberTwo));
	}

	@RequestMapping(value = "/squ/{number}", method = RequestMethod.GET)
	public Double squ(@PathVariable("number") String number) throws Exception {
		if (!numberconverter.isNumeric(number)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		return math.squ(numberconverter.convertToDouble(number));
	}

}
