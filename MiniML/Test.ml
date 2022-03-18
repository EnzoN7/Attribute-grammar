open Semantics
open MiniML
open Types

let getValeur (_,v,_) = v

let getType (t,_,_) = t

(*
  Tests sur les entiers
*)

let%test _ = ( getValeur (miniML "../../exemples/exemple-00.mml") = (IntegerValue 3) )
let%test _ = ( getType (miniML "../../exemples/exemple-00.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-01.mml") = (IntegerValue (-8)) )
let%test _ = ( getType (miniML "../../exemples/exemple-01.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-02.mml") = (IntegerValue 4) )
let%test _ = ( getType (miniML "../../exemples/exemple-02.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-03.mml") = (IntegerValue 5) )
let%test _ = ( getType (miniML "../../exemples/exemple-03.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-04.mml") = (IntegerValue 1) )
let%test _ = ( getType (miniML "../../exemples/exemple-04.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-05.mml") = (IntegerValue 2) )
let%test _ = ( getType (miniML "../../exemples/exemple-05.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-06.mml") = (IntegerValue 120) )
let%test _ = ( getType (miniML "../../exemples/exemple-06.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-07.mml") = (IntegerValue 10) )
let%test _ = ( getType (miniML "../../exemples/exemple-07.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-08.mml") = (IntegerValue 5) )
let%test _ = ( getType (miniML "../../exemples/exemple-08.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-11.mml") = (IntegerValue 120) )
let%test _ = ( getType (miniML "../../exemples/exemple-11.mml") = IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-12.mml") = (IntegerValue 120) )
let%test _ = ( getType (miniML "../../exemples/exemple-12.mml") = IntegerType )

(*
  Tests sur les booléens
*)

let%test _ = ( getValeur (miniML "../../exemples/exemple-10.mml") = (BooleanValue false) )
let%test _ = ( getType (miniML "../../exemples/exemple-10.mml") = BooleanType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-14.mml") = (BooleanValue true) )
let%test _ = ( getType (miniML "../../exemples/exemple-14.mml") = BooleanType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-15.mml") = (BooleanValue true) )
let%test _ = ( getType (miniML "../../exemples/exemple-15.mml") = BooleanType )

(*
  Autres tests
*)

let%test _ = ( getValeur (miniML "../../exemples/exemple-16.mml") = ReferenceValue "ref@1" )
let%test _ = ( getType (miniML "../../exemples/exemple-16.mml") = ReferenceType BooleanType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-17.mml") = ReferenceValue "ref@1" )
let%test _ = ( getType (miniML "../../exemples/exemple-17.mml") = ReferenceType IntegerType )

let%test _ = ( getValeur (miniML "../../exemples/exemple-09.mml") = (FrozenValue (FunctionNode ("x",AccessNode "x"),[])) )
let%test _ = ( getType (miniML "../../exemples/exemple-09.mml") = FunctionType (VariableType (ref UnknownType,1),VariableType (ref UnknownType,1)) )

let%test _ = ( getValeur (miniML "../../exemples/exemple-13.mml") = NullValue )
let%test _ = ( getType (miniML "../../exemples/exemple-13.mml") = UnitType )