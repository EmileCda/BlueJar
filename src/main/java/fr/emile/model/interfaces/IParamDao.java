package fr.emile.model.interfaces;

import fr.emile.entity.Param;

public interface IParamDao {
	Param create (Param param)  throws Exception;
	Param read (int id)  throws Exception;
	Param readByFunctionCode(int functionCode) throws Exception;

	int update (Param param)  throws Exception;
	int delete (Param param)  throws Exception;

}
