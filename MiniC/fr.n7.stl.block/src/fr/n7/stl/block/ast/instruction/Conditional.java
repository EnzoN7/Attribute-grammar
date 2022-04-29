/**
 * 
 */
package fr.n7.stl.block.ast.instruction;

import java.util.Optional;

import fr.n7.stl.block.ast.Block;
import fr.n7.stl.block.ast.SemanticsUndefinedException;
import fr.n7.stl.block.ast.expression.Expression;
import fr.n7.stl.block.ast.instruction.declaration.FunctionDeclaration;
import fr.n7.stl.block.ast.scope.Declaration;
import fr.n7.stl.block.ast.scope.HierarchicalScope;
import fr.n7.stl.block.ast.type.AtomicType;
import fr.n7.stl.block.ast.type.Type;
import fr.n7.stl.tam.ast.Fragment;
import fr.n7.stl.tam.ast.Register;
import fr.n7.stl.tam.ast.TAMFactory;
import fr.n7.stl.tam.ast.TAMInstruction;
import fr.n7.stl.tam.ast.impl.FragmentImpl;

/**
 * Implementation of the Abstract Syntax Tree node for a conditional instruction.
 * @author Marc Pantel
 *
 */
public class Conditional implements Instruction {

	protected Expression condition;
	protected Block thenBranch;
	protected Block elseBranch;

	public Conditional(Expression _condition, Block _then, Block _else) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = _else;
	}

	public Conditional(Expression _condition, Block _then) {
		this.condition = _condition;
		this.thenBranch = _then;
		this.elseBranch = null;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "if (" + this.condition + " )" + this.thenBranch + ((this.elseBranch != null)?(" else " + this.elseBranch):"");
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#collect(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean collectAndBackwardResolve(HierarchicalScope<Declaration> _scope) {
		if (this.elseBranch == null) {
			return this.condition.collectAndBackwardResolve(_scope) && this.thenBranch.collect(_scope);
		} else {
			return this.condition.collectAndBackwardResolve(_scope) && this.elseBranch.collect(_scope) && this.thenBranch.collect(_scope);
		}
	}
	
	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.instruction.Instruction#resolve(fr.n7.stl.block.ast.scope.Scope)
	 */
	@Override
	public boolean fullResolve(HierarchicalScope<Declaration> _scope) {
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#checkType()
	 */
	@Override
	public boolean checkType() {
		if (this.elseBranch == null) {
			return this.condition.getType() == AtomicType.BooleanType && this.thenBranch.checkType();
		} else {
			return this.condition.getType() == AtomicType.BooleanType && this.thenBranch.checkType() && this.elseBranch.checkType();
		}
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#allocateMemory(fr.n7.stl.tam.ast.Register, int)
	 */
	@Override
	public int allocateMemory(Register _register, int _offset) {
		this.thenBranch.allocateMemory(_register, _offset);
		if (this.elseBranch != null) {
			this.elseBranch.allocateMemory(_register, _offset);
		}
		return 0;
	}

	/* (non-Javadoc)
	 * @see fr.n7.stl.block.ast.Instruction#getCode(fr.n7.stl.tam.ast.TAMFactory)
	 */
	@Override
	public Fragment getCode(TAMFactory _factory) {
//		Fragment condFrag = _factory.createFragment();
//		condFrag.append(this.condition.getCode(_factory));
//		condFrag.append(this.thenBranch.getCode(_factory));
//		if (this.elseBranch != null) {
//			condFrag.append(this.elseBranch.getCode(_factory));
//		}
//		return condFrag;
		
//		Fragment _result = _factory.createFragment();
//		_result.add(_factory.createLoad(
//				this.declaration.getRegister(), 
//				this.declaration.getOffset(),
//				this.declaration.getType().length()));
//		_result.addComment(this.toString());
//		return _result;
		
		Fragment condFrag = _factory.createFragment();
//		condFrag.add((TAMInstruction) this.condition.getCode(_factory));
		condFrag.add((TAMInstruction) this.thenBranch.getCode(_factory));
		if (this.elseBranch != null) {
			condFrag.add((TAMInstruction) this.elseBranch.getCode(_factory));
		}
		return condFrag;
	}

	@Override
	public Type returnTo(FunctionDeclaration _f) {
		// TODO Auto-generated method stub
		return null;
	}

}
