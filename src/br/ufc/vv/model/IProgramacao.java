package br.ufc.vv.model;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public interface IProgramacao {

	public String retornaEvento();

	public void addEvento(IEvento evento);

	public Calendar getDiaInicial();

	void setDiaInicial(Calendar data);

	int getQuantidadeDeEventos();

	Iterator<IEvento> getEventos();

	void removerEventos(List<IEvento> eventos);

	void removerEvento(IEvento evento);

	void addListaDeEvento(List<IEvento> eventos);

	ICinema getCinema();

	void setCinema(ICinema cinema);
}
